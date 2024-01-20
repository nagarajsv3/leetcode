LRU Cache is implemented using HashMap<Integer, Node> and Doubly Linked List (Head and Tail Node)
​
* Insert Next to Head Node
* Delete previous of Tail Node
​
Put (Update):
If Item is present in the Map, then Delete From Doubly Linked List and Map.
Put New Insert and Capacity is Full
**Delete LRU (Tail.previous)** From Doubly Linked List and Map.
Insert New  next to head and add it to Map (key, Node)
​
Put New Insert and Capacity is Not Full
Insert New  next to head and add it to Map (key, Node)
​
Get:
If present then Delete From Doubly Linked List and Map.
Newly Insert next to head and add it to Map (key, Node)