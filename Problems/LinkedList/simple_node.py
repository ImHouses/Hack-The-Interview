class SimpleNode:

    def __init__(self, data):
        self.next = None
        self.data = data

    def __str__(self):
        if self.next == None:
            return "{}".format(self.data)
        return "{}->{}".format(self.data, str(self.next))

    def __repr__(self):
        return str(self)
    
if __name__ == "__main__":
    test_node = SimpleNode(1)
    test_node.next = SimpleNode(2)
    test_node.next.next = SimpleNode(3)
    print(test_node)