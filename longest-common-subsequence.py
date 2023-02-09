# str1 = 'abcda'
# str2 = 'bdabac'

def longest_common_subsequence(str1, str2):
    # Create a 2-D array and initialize LCS with 0's
    LCS = [ [0]*(len(str2)+1) for i in range(len(str1) + 1)]

    # Outer loop from 1 to len(str1) which compares each character from str1
    for i in range(1, len(str1) + 1):
        # Inner loop from 1 to len(str2) which compares each character from str2 
        for j in range(1, len(str2) + 1):
            # If the current character in str1 matches with str2 then increment LCS[i][j] with it's last subsequence count else take the max of LCS[i-1][j] and LCS[i][j-1] 
            if str1[i-1] == str2[j-1]:
                LCS[i][j] = LCS[i-1][j-1] + 1
            else:
                LCS[i][j] = max(LCS[i-1][j], LCS[i][j-1])
    # The last element in LCS will be the Longest Common Subsequence.
    return LCS[len(str1)][len(str2)]

def main():
    str1 = input("Enter the first string: ")
    str2 = input("Enter the second string: ")
    print(f'The longest common subsequence count is {longest_common_subsequence(str1, str2)}.')


if __name__ == "__main__":
    main()
