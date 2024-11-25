import socket
import threading
import sys 
# Server configuration
SERVER_HOST = '127.0.0.1'
SERVER_PORT = 12345
BUFFER_SIZE = 1024

isServer = 0
# Function to handle each client connection
def handle_client(client_socket, address):
    global isServer
    print(f"[+] Connected with {address}")

    while True:
        # Receive data from client
        data = client_socket.recv(BUFFER_SIZE)
        print("Data here ", data)
        if not data:
            break
        if data == b'STOP_SERVER':
            isServer = 1
            print("Here is data", data)
            print("Server is stopped by client\' input.")
            sys.exit(0)
        # Echo back the received data
        client_socket.sendall(data)
    
    # Close connection with client
    client_socket.close()
    print(f"[-] Connection with {address} closed")

# Function to start the server
def start_server():
    global isServer
    # Create a TCP socket
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    
    # Bind the socket to the server address
    server_socket.bind((SERVER_HOST, SERVER_PORT))
    
    # Listen for incoming connections
    server_socket.listen(5)
    print(f"[*] Listening on {SERVER_HOST}:{SERVER_PORT}")
    
    while not isServer:
        # Accept incoming connection
        client_socket, address = server_socket.accept()
        
        # Create a new thread to handle the client
        client_thread = threading.Thread(target=handle_client, args=(client_socket, address))
        client_thread.start()

if __name__ == "__main__":
    start_server()
