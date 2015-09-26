import Test.HUnit

{-
 - Problem 1: Closures.
 - Implement an immutable map (dictionary / hash) with String keys and Int values.
 - Don't use any ADTs or built-in data structures (no Pairs, no Lists etc.).
 - Use just functions, storing all data in closures.
 -}

type Map = () -- Fill in the type here!

emptyMap :: Map
emptyMap = undefined -- What is an empty map?

fetch :: Map -> String -> Maybe Int
fetch = undefined -- How to fetch something?

store :: Map -> String -> Int -> Map
store = undefined -- And how to store?

--------------------------------------------------------------------------------
-----------------------------------TEST CASES-----------------------------------
--------------------------------------------------------------------------------

testEmptyMap = TestCase $ assertEqual "Retrieving anything from an empty map yields Nothing"
                                      Nothing
                                      (fetch emptyMap "some key")

testFetchAfterStore = TestCase $ assertEqual "store actually stores values"
                                             (Just 40)
                                             (fetch (store emptyMap "some key" 40) "some key")

testLongerChainOfStores = TestCase $ assertEqual "the values persist between stores"
                                                 (Just 40)
                                                 (fetch biggerMap "some key")
                          where biggerMap = store (store emptyMap "some key" 40) "other key" 50

testShadowing = TestCase $ assertEqual "new stores in the same key shadow old stores"
                                       (Just 75)
                                       (fetch shadowMap "some key")
                where shadowMap = store (store emptyMap "some key" 40) "some key" 75

main = runTestTT $ TestList [ testEmptyMap
                            , testFetchAfterStore
                            , testLongerChainOfStores
                            , testShadowing ]
