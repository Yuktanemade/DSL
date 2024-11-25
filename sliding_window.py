import time
import random
from collections import deque

# Constants
WINDOW_SIZE = 4
TIMEOUT = 1  # seconds
MAX_SEQ = 8  # Maximum sequence number (wraps around)

class Sender:
    def __init__(self):
        self.window = deque()  # Sliding window
        self.seq_num = 0  # Start with sequence number 0
    
    def send_packet(self, packet):
        # Simulate sending a packet (this could be a network send)
        print(f"Sending packet: {packet}")
    
    def slide_window(self):
        # Slide window forward if the window has received acknowledgment for the oldest packet
        if len(self.window) >= WINDOW_SIZE:
            ack = self.window.popleft()  # Simulate receiving acknowledgment
            print(f"Acknowledgment received for: {ack}")
    
    def transmit(self):
        while self.seq_num < MAX_SEQ:
            # Add a packet to the window
            self.window.append(self.seq_num)
            self.send_packet(self.seq_num)
            self.seq_num += 1

            # Wait for an acknowledgment (simulate a timeout for simplicity)
            self.slide_window()

            time.sleep(TIMEOUT)  # Simulate delay

class Receiver:
    def __init__(self):
        self.expected_seq = 0  # Start expecting sequence number 0
    
    def receive_packet(self, packet):
        if packet == self.expected_seq:
            print(f"Receiver: Correct packet received, seq = {packet}")
            self.expected_seq += 1  # Expect the next sequence number
            return True
        else:
            print(f"Receiver: Out of order packet, expected {self.expected_seq}, but got {packet}")
            return False

def simulate_sliding_window_protocol():
    sender = Sender()
    receiver = Receiver()
    
    # Start sender and receiver in parallel (for simulation purposes)
    sender.transmit()

    # Simulate the receiver receiving packets (this could be a network layer receiving process)
    for seq in range(MAX_SEQ):
        time.sleep(random.uniform(0.5, 2))  # Simulate network delay
        if not receiver.receive_packet(seq):
            print(f"Receiver: Retransmitting ack for packet {seq}")
        else:
            print(f"Receiver: Sending ack for {seq}")

if __name__ == "__main__":
    simulate_sliding_window_protocol()
