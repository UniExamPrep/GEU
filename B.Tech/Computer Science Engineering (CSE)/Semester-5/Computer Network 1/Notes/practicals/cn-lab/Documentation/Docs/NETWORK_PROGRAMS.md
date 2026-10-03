# TCP and UDP Client-Server Programs (C)

This folder contains example implementations for TCP and UDP client-server communication in C.

Files added:

- `tcp_server.c`: simple TCP server that accepts one connection, reads a message, and replies.
- `tcp_client.c`: simple TCP client that connects to the server, sends a message, and reads the reply.
- `udp_server.c`: simple UDP server that receives a datagram and replies.
- `udp_client.c`: simple UDP client that sends a datagram and waits for a reply.

Compile:

    gcc -o tcp_server tcp_server.c
    gcc -o tcp_client tcp_client.c
    gcc -o udp_server udp_server.c
    gcc -o udp_client udp_client.c

Run examples:

1. TCP

    Terminal 1: ./tcp_server
    Terminal 2: ./tcp_client

2. UDP

    Terminal 1: ./udp_server
    Terminal 2: ./udp_client

Problem statements and solutions are implemented as requested.
