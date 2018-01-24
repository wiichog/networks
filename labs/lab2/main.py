#Juan Luis Garcia 
#Carnet 14189
#Redes
import socket
import thread

HOST, PORT = '', 8888

def response():
	request = client_connection.recv(1024)
   	print request
	#abrimos un txt grande para simular una carga en el servidor y poder probar el multithreading
	file = open("dummy.txt")
    	http_response = """\
	HTTP/1.1 200 OK

	<html><link rel="icon" type="image/vnd.microsoft.icon" href="http://s2.googleusercontent.com/s2/favicons?domain_url=http://domain.com">
	Hello World {}
	</html>
	""".format(file.read())
	print(type(http_response))
    	client_connection.sendall(http_response)
    	client_connection.close()

listen_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
listen_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
listen_socket.bind((HOST, PORT))
listen_socket.listen(1)
print 'Server 14189 HTTP serving on port %s ...' % PORT
while True:
    client_connection, client_address = listen_socket.accept()
    thread.start_new_thread(response,())
