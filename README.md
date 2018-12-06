# HashMap with open addressing and linear probing algorithm
HashMap implementation with open addressing and linear probing algorithm 

Open addressing, or closed hashing, is a method of collision resolution in hash tables. With this method a hash collision is resolved by probing, or searching through alternate locations in the array (the probe sequence) until either the target record is found, or an unused array slot is found, which indicates that there is no such key in the table. Well-known probe sequences include:

Linear probing 
in which the interval between probes is fixed — often set to 1.

Quadratic probing 
in which the interval between probes increases quadratically (hence, the indices are described by a quadratic function).

Double hashing 
in which the interval between probes is fixed for each record but is computed by another hash function.


