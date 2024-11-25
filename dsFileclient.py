import socket

def receive_file(server_socket, filename):
    """Receive file from the server."""
    status = server_socket.recv(1024).decode()
    if status == "OK":
        with open(filename, 'wb') as file:
            while True:
                data = server_socket.recv(1024)
                if not data:
                    break
                file.write(data)
        print(f"File '{filename}' received successfully.")
    else:
        print("File not found on the server.")

def start_client():
    """Start the file transfer client."""
    server_address = ('127.0.0.1', 12345)  # Connect to the server on localhost and port 12345
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    try:
        client_socket.connect(server_address)  # Establish the connection to the server
        filename = input("Enter the filename to request: ")
        client_socket.send(filename.encode())  # Send filename request to the server
        receive_file(client_socket, filename)  # Call function to receive the file
    except socket.error as e:
        print(f"Connection error: {e}")
    finally:
        client_socket.close()  # Ensure the socket is closed after the operation is done

if __name__ == "__main__":
    start_client()  # Start the client process
