import socket
import os

def send_file(client_socket, filename):
    """Send the specified file to the client."""
    if os.path.isfile(filename):
        client_socket.send(b"OK")  # Send acknowledgment
        with open(filename, 'rb') as file:
            while True:
                data = file.read(1024)  # Read in chunks
                if not data:
                    break
                client_socket.send(data)
        print(f"File '{filename}' sent successfully.")
    else:
        client_socket.send(b"ERROR")  # File not found

def start_server():
    """Start the file transfer server."""
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind(('0.0.0.0', 12345))
    server_socket.listen(5)
    print("Server is listening on port 12345...")

    while True:
        client_socket, addr = server_socket.accept()
        print(f"Connection from {addr}")
        
        # Receive filename request
        filename = client_socket.recv(1024).decode()
        print(f"Requested file: {filename}")
        
        # Send the requested file
        send_file(client_socket, filename)
        
        # Close the connection after the file is sent
        client_socket.close()

if __name__ == "__main__":
    start_server()  # Start the server
