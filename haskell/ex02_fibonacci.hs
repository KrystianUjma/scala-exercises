import Test.HUnit

{-
 - Problem 2: Tail-Recursion and Coinduction.
 - Implement two functions for computing fibonacci sequence.
 - First function should be tail-recursive.
 - Second should make use of infinite lists.
 -}

tailFibonacci :: Int -> Integer
tailFibonacci n =  undefined -- Tail recursive version here!

fibs :: [Integer]
fibs = undefined -- List definition here!

listFibonacci :: Int -> Integer
listFibonacci n = fibs !! n

--------------------------------------------------------------------------------
-----------------------------------TEST CASES-----------------------------------
--------------------------------------------------------------------------------

testCases = [(0, 0), (3, 2), (7, 13), (47, 2971215073)]

testFiboCase fun pos out = TestCase $ assertEqual "input matches output" out (fun pos)

testFibonacciImpl f = [testFiboCase f pos out | (pos, out) <- testCases]

main = runTestTT $ TestList $ (testFibonacciImpl tailFibonacci) ++ (testFibonacciImpl listFibonacci)
