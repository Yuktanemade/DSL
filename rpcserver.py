from xmlrpc.server import SimpleXMLRPCServer
import xmlrpc.client

# Define the factorial function
def fact(n):
    if n < 0:
        return 0
    elif n == 0 or n == 1:
        return 1
    else:
        factorial = 1
        while n > 1:
            factorial *= n
            n -= 1
        return factorial

# Set up the XML-RPC server
server = SimpleXMLRPCServer(("localhost", 8000))
print("Server is listening on port 8000...")
server.register_function(fact, "fact")
server.serve_forever()
