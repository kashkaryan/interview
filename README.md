# Interview

A short glance at difficult interview questions on graphs and algorithms provided by Penn CIS121 staff.

Homework 10: Algorithmic Programming
Interview Questions
Due by 4:00pm EDT on Monday, May 4, 2020
5 out of 6 Problems (100 points)
Important: This assignment is in a completely different format than previous programming assignments. It is imperative
that you read through the entire writeup very carefully.
Setup and Logistics
We have put together several stub files –– click here to download them (/~cis121/current/hw/10-interviewquestions/hw10-stub-files.zip).
5 files to submit: Any 5 of Question1.java , Question2.java , Question3.java , Question4.java , Question5.java ,
and Question6.java
Please do not submit any additional files.
Be sure to follow these guidelines:
Ensure source files are not located in any package and that none of the files have a package declaration (e.g. package
src; ).
When submitting, submit each file individually at the root level (not contained in a folder or zip files).
Ensure that your own test files pass and do not run into infinite loops.
For this assignment:
Number of Free Submissions: Unlimited
Max Style Score Deduction: up to 5 points
Do not wait until the last minute to try submitting. You are responsible for ensuring your submission goes through by the
deadline.
Before asking questions on Piazza, be sure to check and keep updated with the pinned clarifications post.
Gradescope issues? Be sure to check out our Gradescope help page (/~cis121/current/gradescope_help.html)
before posting to Piazza.
Motivation – Interview Preparation
This homework is intended to help you review and apply concepts you learned throughout the semester, and to help you
prepare for algorithmic programming interviews you may encounter. These questions are similar to those you may encounter on
HackerRank (or similar sites), and are on the medium difficulty level.
Learning Objectives:
Ensure you are able to implement algorithms in Java
Familiarize yourself with Java syntax and libraries
Review key CIS 121 concepts:
Algorithm design paradigms (recursion, divide and conquer, etc.)
Basic data structures (arrays, sets, queues, etc.)
Sorting and selection
Graph algorithms (BFS, DFS, etc.)
You will notice that these questions are very similar to the written questions you had to do for various assignments in this
course. This time around, you will actually implement your algorithms!
Often times, this comes with some challenges. Sure, it’s easy to say “run BFS” as a black box, but implementing it on the
fly is a bit different, especially if you need to apply it to a certain problem. This assignment will give you practice applying
what you’ve learned.
Testing
We are not asking you to submit unit tests for this homework. However, we still expect that you write test cases as it will be
very difficult to do well on this homework without thoroughly testing your code on a variety of inputs. In short, you should
still be unit testing even if we aren’t asking you to submit your tests.
To help you out a bit, we will be providing one test case per question, which is sometimes common practice in on-line coding
samples. This test is only there to make sure you are understanding the problem correctly, and that you are hopefully headed in
the right direction. These tests are explained in the write-up after each problem below, and will be available on Gradescope.
Grading
Each solution will be manually reviewed by a TA to ensure it meets our target runtime. Solutions that meet our target runtime will
not be deducted any points manually. Partial credit (and possibly some efficiency penalties) will be given for incorrect and/or
inefficient solutions. Note that brute force and extremely inefficient solutions are not likely to receive many points (even if
they pass our automated tests).
Style will be graded based on the CIS 121 Style Guide (/~cis121/current/java_style_guide.html), and will be done on a
subtractive basis. As with previous assignments, you will be able to see and fix the style errors upon submission.
No Office Hours Policy
Since this assignment is replacing your final exam, we would like you to think about these questions completely on your own,
without any help from TAs at office hours. These problems are challenging, but you will get the most of out them if you spend
time coming up with these solutions on your own.
Should you require a clarification on a problem, feel free to ask on Piazza.
Algorithmic Interview Questions (100 points)
In this section, you will be implementing five out of six algorithmic programming questions. All instructions are both below and
in the respective question’s .java file. The one provided test case per question is also listed below. Make sure to take a look
at the test case to confirm your understanding of the question.
You must think about and implement these questions completely on your own (it is also against course policy to consult other
sources, including your friends and the Internet).
Question 0: Word Ladder (EXAMPLE - 0 points)
This is likely your first time implementing these types of questions, so we want you to walk yourself through the entire process
of solving one of these questions. This question was used on last semester’s assignment.
Please be sure to read through the entirety of this article, so you understand the thought process needed to solve these sorts of
questions, and how you should actually go about implementing them.
Some tips to keep in mind:
If your solution is many (>100) lines of code, you are likely over complicating something
You should never need to use explicit graph inner classes. Use the input directly instead (see the way we did this in the
sample solution).
Only use hashing where we provide you with an expected runtime. Usually, you’re never given a target runtime in
interviews, so hashing is usually a good way to bring the expected runtime down, but for the purposes of this assignment
we sometimes want you to think of questions in different ways.
Word Ladder Problem & Solution (https://leetcode.com/articles/word-ladder/)
Please do not continue until you have read the article above carefully, and have understood the solution.
Question 1: Flight Schedules (20 points)
File to Submit: Question1.java
Target Runtime: , where and .
Please read the documentation for Question1.java below carefully, and then confirm your understanding of the problem by
reading the test case below.
Problem Description
You are the newest flight dispatcher recruit, and given your computer science background your manager assigns you a task to
complete on day one. She’s tired of manually figuring out what order the planes can depart in given some restrictions, so she
enlists your help in automating this process.
More formally, there are n planes waiting to take off labeled 0 -> n - 1 . Some flight plans have conditions that must be met.
For example, for flight 0 to take off, flight 7 must have taken off already. This is expressed as the pair [0, 7] .
Given the number of flights waiting to take off and a list of condition pairs, design and implement an algorithm to schedule all
the flights. Sometimes, multiple flight schedules might exist – in that case, return any one of them. If it’s not possible to
schedule all the flights, then return an empty list.
Public Test Case
Upon submission, we will be running your code against the following test case. This test case is basic, so please don’t rely on
it. Note: You will be deducted 4 points if you hard-code this test case.
Input: numFlights = 4, conditions = [[3, 2], [1, 2], [0, 3], [0, 1]]
Output: [2, 3, 1, 0] or [2, 1, 3, 0] , as for flight 0 to have departed, flights 3 and 1 should have departed before as
well. Additionally, flights 3 and 1 should have left after flight 2, so those are the two options we have.
Question 2: Roommate Matching (20 points)
File to Submit: Question2.java
Target Runtime: , where is the number of pairs. Note: without the constraint below, it is possible to do better in
expectation.
Other Constraints: You may use additional space other than your output set. Should you choose to use it, you may
assume that Java’s built-in sorting method is in-place (even though in reality it often times uses more than space). You
may also not use the set’s contains() method.
Please read the documentation for Question2.java below carefully, and then confirm your understanding of the problem by
reading the test case below.
For this question only, the use of inner classes is fine (you may or may not need to use one!).
𝑂(𝑚 + 𝑛) 𝑛 = 𝚗𝚞𝚖𝙵𝚕𝚒𝚐𝚑𝚝𝚜 𝑚 = 𝚌𝚘𝚗𝚍𝚒𝚝𝚒𝚘𝚗𝚜.𝚕𝚎𝚗𝚐𝚝𝚑
𝑂(𝑛 lg 𝑛) 𝑛
𝑂(1)
𝑂(1)
You may use a HashSet for the output set ONLY!
Problem Description
After implementing the stable matching solution for the CIS department’s waitlist problem, Penn Residential Services (aka Penn
RES) seeks your help for matching roommates. Their problem seems much simpler, though, so you accepted their request for
help immediately.
Penn RES gives you a 2d-array of pairs of the form (student, requested roommate) . Each student is only allowed to
request one roommate. Penn RES wants to save time, so they want to automatically match all students who mutually request
each other.
Your task will be to return a set of pairs of students who mutually requested each other, given a 2d-array of pairs, in
time.
Public Test Case
Upon submission, we will be running your code against the following test case. This test case is basic, so please don’t rely on
it. Note: You will be deducted 4 points if you hard-code this test case.
Input: requests[][] = { {"Steven", "Will"}, {"Helen", "Caroline"}, {"Caroline", "Monal"}, {"Will",
"Steven"} }
Output: {("Steven", "Will")} or {("Will", "Steven")} (either order is fine) since Steven requested Will and Will
requested Steven. There is no other pair who mutually requested each other.
Question 3: Bunny Hop (20 points)
File to Submit: Question3.java
Target Runtime: where
Please read the documentation for Question3.java below carefully, and then confirm your understanding of the problem by
reading the test case below.
Problem Description
A bunny is stuck in center city and is trying to get back home to Penn as quickly as possible. The bunny has a map of the city,
which happens to be an 2d-array of positive integers (where ), where each entry defines how many cells the bunny
can hop up or to the left when that entry is reached (note that bunny must hop exactly that many cells, not more and not less).
Center city happens to be the bottom right corner of the 2d-array, and Penn happens to be the top left corner, so the bunny’s
goal is to reach the top-left corner in the fewest number of hops.
Your goal here is to determine what the minimum number of hops would be, given a 2d-array of the city, in time. If
no path is possible, you should return -1 to indicate so.
Note: for a given entry in the array, all hops from that location have to be up or left (i.e., you cannot distribute these hops)
Public Test Case
Upon submission, we will be running your code against the following test case. This test case is basic, so please don’t rely on
it. Note: You will be deducted 4 points if you hard-code this test case.
Input:
𝑂(𝑛 lg 𝑛)
𝑂(𝑛 )
2 𝑛 = 𝚌𝚒𝚝𝚢.𝚕𝚎𝚗𝚐𝚝𝚑
𝑛 × 𝑛 𝑛 ≥ 2
𝑛 × 𝑛 𝑂(𝑛 )
2
𝑥 𝑥
city[][] = { {1, 6, 2},
 {1, 6, 4},
 {1, 9, 2} }
Output: 2 because the minimum number of hops is from city[2][2] city[0][2] city[0][0] . Note that another
path exists, namely city[2][2] city[2][0]
city[1][0] city[0][0] . However, this path is longer and would require 3 hops.
Question 4: Minimum Plane Moves (20 points)
File to Submit: Question4.java
Target Runtime: expected , where
Please read the documentation for Question4.java below carefully, and then confirm your understanding of the problem by
reading the test case below.
Problem Description
Word has gotten around that you are pretty good at automating some tedious manual tasks. This time, the Air Force decides to
hire you, and asks for an interesting favor.
The General wants to make sure all bases have the same number of planes. However, moving planes is expensive, and he’s
trying to keep costs low. He has two options:
1. Send a plane to the overseas storage facility (i.e., away from all bases) which always has an unlimited supply of planes.
2. Bring back a plane from the overseas storage facility (i.e., to one of the bases).
He wants to know what the smallest number of plane moves needed for all bases to end up with the same number of planes.
Remember that the overseas storage facility has unlimited supply. Your goal is to write an expected algorithm that
automates this task, given an int[] numPlanes .
There are n bases, and the number of planes at each base is stored in an int[] numPlanes . That means that at base i ,
there are numPlanes[i] planes.
Public Test Case
Upon submission, we will be running your code against the following test case. This test case is basic, so please don’t rely on
it. Note: You will be deducted 4 points if you hard-code this test case.
Input: numPlanes = [3, 4, 5]
Output: 2 , as you have to bring a plane from overseas for base 0, and send a plane from base 2 overseas. Then you end up
with [4, 4, 4] .
Question 5: Odd Sized Family Trees (20 points)
File to Submit: Question5.java
Target Runtime: , where is the number of family members
Please read the documentation for Question5.java below carefully, and then confirm your understanding of the problem by
reading the test case below.
Problem Description
Due to your interest in genealogy, many families have recently approached you with their family trees. In all of these family trees,
spouses are not included, so all members of the tree are blood related. These families have all managed to trace their ancestry
pretty far back. Each person in each family has a unique favorite number. The unique number is a number from
→ →
→
→ →
𝑂(𝑛) 𝑛 = 𝚗𝚞𝚖𝙿𝚕𝚊𝚗𝚎𝚜.𝚕𝚎𝚗𝚐𝚝𝚑
𝑂(𝑛)
𝑂(𝑛) 𝑛
0 → 𝑛 − 1
where is the number of family members.
The governor of your city has decided to make a competition that the family with the most number of odd sized sub-trees wins
1 million dollars! Due to your popularity, thousands of families are now sending their extensive family trees to you so you can
check how many odd sized sub-trees they have, in exchange for a portion of the 1 million dollars.
Your goal, then, is to write an efficient algorithm that returns how many odd sized sub-trees a given family tree has.
Public Test Case
Upon submission, we will be running your code against the following test case. This test case is basic, so please don’t rely on
it. Note: You will be deducted 4 points if you hard-code this test case.
Input: Your input will be given to you as an adjacency list where the list at index stores the children of . The number for each
node represents the unique favorite number of each family member. Remember, the favorite numbers go from , they
are unique, and represents the number of family members. This is the visualized tree:
tree = 0 <-- root
 / \
 1 3
 / | \ \
 2 4 5 6
Output: 5 . The sub-trees rooted at 0, 2, 4, 5, and 6 all have odd size.
Question 6: Sum of Cards (20 points)
File to Submit: Question6.java
Target Runtime: expected , where is the number of cards
Please read the documentation for Question6.java below carefully, and then confirm your understanding of the problem by
reading the test case below.
Problem Description
You are at Vegas, and the dealer has offered you a once in a lifetime opportunity to win money in a new game called “Sum of
Cards”.
The game is played as follows: the dealer lays out cards with some integer on each card, and then pays you based on one of
the following methods (which you are to choose):
Version 1: the dealer will sum all of the cards laid out, and if the sum is positive will pay you half that amount (rounded
down). Otherwise, you pay the dealer half the sum.
Version 2: the dealer will find the sum of payout(cards[a], cards[b]) for all pairs (a, b) such that 0 <= a < b
<= n - 1 (note cards[] is 0-indexed), where payout is defined as:
 if |y - x| > 1:
 payout(x, y) = y - x
 else:
 payout(x, y) = 0
If the sum is positive the dealer will pay you that amount. Otherwise, you pay the dealer the sum.
Before making your decision, you want to run some trials and have thus decided to implement an expected algorithm that
would do this calculation for you.
The dealer is waiting, so you want this to be quick before he changes his mind about letting you play. Come up with an
expected algorithm for version 2, where is the number of cards.
𝑛
𝑂(𝑛)
𝑖 𝑖
0 → 𝑛 − 1
𝑛
𝑂(𝑛) 𝑛
𝑛
𝑛
𝑂(𝑛)
𝑂(𝑛) 𝑛
The TA staff wants to help you make your decision quickly, so they have implemented part of it for you. Yes, of course – you’re
very welcome! :)
Public Test Case
Upon submission, we will be running your code against the following test case. This test case is basic, so please don’t rely on
it. Note: You will be deducted 4 points if you hard-code this test case.
Input: cards = [1, 7, 2, 3]
Output: -1 , as
This assignment was developed by the CIS 121 Staff.
Last updated on Wed, Apr 29 at 12:40 PM.
payout(1, 7) + payout(1, 2) + payout(1, 3) + payout(7, 2) + payout(7, 3) + payout(2, 3) = 6 + 0 + 2 + −5 + −4 + 0 = −1
