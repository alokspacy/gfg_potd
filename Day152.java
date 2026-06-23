// Maximum Number of People Defeated

class Solution {
int maxPeopleDefeated(int p) {
// code here
int i = 1;
int count = 0;
while (p >= (i*i))
{
       p = p - (i*i);
       count++;
       i++;
}
return count;
}
};
