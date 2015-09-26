import Test.HUnit

{-
 - Problem 4: List Combinators.
 - Using only foldl and foldr (no recursion etc.) implement the following list combinators:
 - a) reverse'
 - b) map'
 - c) filter'
 - d) (+++)
 - e) concat'
 - Bonus points for using currying and point-free notation :).
 -}

reverse' :: [a] -> [a]
reverse' = undefined

map' :: (a -> b) -> [a] -> [b]
map' = undefined

filter' :: (a -> Bool) -> [a] -> [a]
filter' = undefined

(+++) :: [a] -> [a] -> [a]
(+++) = undefined

concat' :: [[a]] -> [a]
concat' = undefined

--------------------------------------------------------------------------------
-----------------------------------TEST CASES-----------------------------------
--------------------------------------------------------------------------------

testReverse = TestCase $ assertEqual "revese' reverses" [3, 2, 1] (reverse' [1, 2, 3])

testMap = TestCase $ assertEqual "map' maps" [2, 3, 4] (map' (+ 1) [1, 2, 3])

testFilter = TestCase $ assertEqual "filter' filters" [2, 4] (filter' even [1, 2, 3, 4])

testPlusPlusPlus = TestCase $ assertEqual "+++ appends" [1, 2, 3, 4] ([1, 2] +++ [3, 4])

testConcat = TestCase $ assertEqual "concat' concats" [1, 2, 3, 4, 5] (concat' [[1, 2], [3, 4], [5]])

main = runTestTT $ TestList [ testReverse
                            , testMap
                            , testFilter
                            , testPlusPlusPlus
                            , testConcat ]
