"""
- Anirudha Verma (20128760)
- CISC 235 - Assignment 1
- I confirm that this submission is my own work and is consistent with the Queen's regulations on Academic Integrity
- @18AnirudhaV

"""

"""
- Returns the number of functions calls required to find the target
- returns index of target in A, if present
- returns -1 if target is not present in A
"""
def bin_search(A,first,last,target):
    if first > last:
        return -1
    else:
        mid = (first+last)//2
        if A[mid] == target:
            return 1
        elif A[mid] > target:
            return 1 + bin_search(A,first,mid-1,target)
        else:
            return 1 + bin_search(A,mid+1,last,target)

"""
- Returns number of function calls required to find the target
- returns index of target in A, if present
- returns -1 if target is not present in A
"""
def trin_search(A,first,last,target):
    if first > last:
        return -1
    else:
        one_third = first + (last-first)//3
        two_thirds = first + 2*(last-first)//3
        if A[one_third] == target:
            return 1
        elif A[one_third] > target:
            # search the left-hand third
            return 1 + trin_search(A,first,one_third-1,target)
        elif A[two_thirds] == target:
            return 1
        elif A[two_thirds] > target:
            # search the middle third
            return 1 + trin_search(A,one_third+1,two_thirds-1,target)
        else:
            # search the right-hand third
            return 1 + trin_search(A,two_thirds+1,last,target)


# Experiment 1

print("Experiment 1:\n")

sizes = [1000, 2000, 4000, 8000, 16000]
exp1List = []
for i in range(16000):
    exp1List.append(i)

for size in sizes:
    average_binary = 0
    average_trinary = 0
    for target in range(size):
        average_binary += bin_search(exp1List, 0, size-1, target)
        average_binary /= 2

        average_trinary += trin_search(exp1List, 0, size - 1, target)
        average_trinary /= 2
    print("Size " + str(size) + " Bin: " + str(average_binary) + " Tri: " + str(average_trinary))


# Experiment 2

print("\nExperiment 2:\n\n")

sizes = [1000, 2000, 4000, 8000, 16000]
exp2List = []
for i in range(1, 2 * 16000, 2):
    exp2List.append(i)

for size in sizes:
    average_binary = 0
    average_trinary = 0
    for target in range(0, 2 * size, 2):
        average_binary += bin_search(exp2List, 0, size-1, target)
        average_binary /= 2

        average_trinary += trin_search(exp2List, 0, size - 1, target)
        average_trinary /= 2
    print("Size " + str(size) + " Bin: " + str(average_binary) + " Tri: " + str(average_trinary))