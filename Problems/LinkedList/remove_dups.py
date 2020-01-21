from simple_node import SimpleNode
import random

# TODO: Solve without a HashTable.
def remove_dups(head):
    if not head:
        return
    current = head
    repetitions = {}
    while current:
        if not current.data in repetitions:
            repetitions[current.data] = 0
        else:
            repetitions[current.data] += 1
        current = current.next
    current = head.next
    prev = head
    while current:
        if repetitions[current.data] > 0:
            prev.next = current.next
            repetitions[current.data] -= 1
            current = current.next
        else:
            prev = current
            current = current.next
            

if __name__ == "__main__":
    current = SimpleNode(1)
    head = current
    for i in range(3):
        current.next = SimpleNode(random.randint(0,5))
        current = current.next
    print(head)
    remove_dups(head)
    print(head)