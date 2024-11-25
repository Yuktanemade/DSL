import xmlrpc.client  

# Connect to the server
proxy = xmlrpc.client.ServerProxy("http://localhost:8000/")

# Get user input
n = int(input("Enter a number to calculate factorial: "))

# Call the remote factorial function
factorial = proxy.fact(n)

# Display the result
print("Response from server..")
print("Factorial of number is:", factorial)
