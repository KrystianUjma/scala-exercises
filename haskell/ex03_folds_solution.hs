import Test.HUnit

{-
 - Problem 3: Folds.
 - Implement three versions of fold function.
 - a) foldl' - tail recursive function applying the function in the left-to-right order.
 - b) foldr' - non-tail recursive, applying right-to-left.
 - c) folds  - using list-manipulation techniques generate a list of all partial results
 -             of folding in the left-to-right order.
 -}

foldl' :: (b -> a -> b) -> b -> [a] -> b
foldl' _ acc [] = acc
foldl' f acc (x:xs) = foldl' f (f acc x) xs

foldr' :: (a -> b -> b) -> b -> [a] -> b
foldr' _ acc [] = acc
foldr' f acc (x:xs) = f x (foldr' f acc xs)

folds :: (a -> b -> b) -> b -> [a] -> [b]
folds f acc xs = accs where accs = acc : (zipWith f xs accs)

--------------------------------------------------------------------------------
-----------------------------------TEST CASES-----------------------------------
--------------------------------------------------------------------------------

testFoldlSum = TestCase $ assertEqual "summing the list with foldl' works" 10 (foldl' (+) 0 [1, 2, 3, 4])

testFoldlOrder = TestCase $ assertEqual "folding with (:) reverses the list"
                                        [3, 2, 1]
                                        (foldl' (flip (:)) [] [1, 2, 3])

testFoldrSum = TestCase $ assertEqual "summing the list with foldr' works" 10 (foldr' (+) 0 [1, 2, 3, 4])

testFoldrOrder = TestCase $ assertEqual "folding with (:) does not reverse the list"
                                        [1, 2, 3]
                                        (foldr' (:) [] [1, 2, 3])

testFoldsSum = TestCase $ assertEqual "summing the list with folds yields list of partial sums"
                                      [0, 1, 3, 6, 10]
                                      (folds (+) 0 [1, 2, 3, 4])

main = runTestTT $ TestList [ testFoldlSum
                            , testFoldlOrder
                            , testFoldrSum
                            , testFoldrOrder
                            , testFoldsSum ]
