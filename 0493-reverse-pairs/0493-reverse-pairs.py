# lee215
class Solution:
    def reversePairs(self, A: List[int]) -> int:
        s = SortedList()
        res = 0
        for a in A:
            res += len(s) - s.bisect_right(a * 2)
            s.add(a)
        return res
        