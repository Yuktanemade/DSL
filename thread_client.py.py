import socket

# Server configuration
SERVER_HOST = '127.0.0.1'
SERVER_PORT = 12345
BUFFER_SIZE = 1024

def start_client():
    # Create a TCP socket
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    
    try:
        # Connect to the server
        client_socket.connect((SERVER_HOST, SERVER_PORT))

        while True:
            # Ask for user input
            choice = input("Enter 0 to stop connection, 1 to stop server: ")
            if choice == '0':
                break
            elif choice == '1':
                # Send a special message to the server to stop
                client_socket.sendall(b"STOP_SERVER")
                break
            else:
                print("Invalid choice. Enter 0 or 1.")

    finally:
        # Close the connection
        client_socket.close()

if __name__ == "__main__":
    start_client()

