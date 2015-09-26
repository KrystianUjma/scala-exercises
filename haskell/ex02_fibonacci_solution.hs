import Test.HUnit

{-
 - Problem 2: Tail-Recursion and Coinduction.
 - Implement two functions for computing fibonacci sequence.
 - First function should be tail-recursive.
 - Second should make use of infinite lists.
 -}

tf :: Int -> Integer -> Integer -> Integer
tf 0 a b = a
tf n a b = tf (n - 1) b (a + b)

tailFibonacci :: Int -> Integer
tailFibonacci n = tf n 0 1

fibs :: [Integer]
fibs = 0 : 1 : (zipWith (+) fibs (drop 1 fibs))

listFibonacci :: Int -> Integer
listFibonacci n = fibs !! n

--------------------------------------------------------------------------------
-----------------------------------TEST CASES-----------------------------------
--------------------------------------------------------------------------------

testCases = [(0, 0), (3, 2), (7, 13), (47, 2971215073)]

testFiboCase fun pos out = TestCase $ assertEqual "input matches output" out (fun pos)

testFibonacciImpl f = [testFiboCase f pos out | (pos, out) <- testCases]

main = runTestTT $ TestList $ (testFibonacciImpl tailFibonacci) ++ (testFibonacciImpl listFibonacci)
