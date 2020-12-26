import random

# TASK 1
def sin(x):
  # Factorial function
  def factorial(num):
    ans = 1;
    for i in range(1, num+1):
      ans *= i

    return ans

  # Function variables
  result = 0.0
  power = 1
  isEven = True
  term = 1
  n = 1

  # implement the function until we will find the accurate value  
  while term + result != result:
    # ith value of Formula
    curValue = (x ** power)/factorial(power)
    term = term * curValue / n
    power += 2

    if isEven:
      isEven = False
      result += curValue
    else:
      isEven = True
      result -= curValue

    n += 1

  return result
      

# TASK 2
def guess():
  # important game state variables
  upperbound = 1000
  lowerbound = 0
  secret = random.randrange(upperbound)
  countGuesses = 0
  isGameActive = True

  print( "Hello, please guess my secret number" )
  print( f"The number is between {lowerbound} and " + f"{upperbound}\n")

  while isGameActive:
    # Update game state / Read input values
    countGuesses += 1
    mess = f"Guess #{countGuesses}: "
    attempt = input(mess)
    guess = int(attempt)
    
    # Victory
    if guess == secret:
      print( "Victory! You attempted " + str(countGuesses) + " times")
      if countGuesses <= 7:
        print( "Very nice result! You have a good intuition!" )
      else:
        print( "Not bad! Try striking from max 7 attempts" )
      isGameActive = False

    # The Guess is higher than actual
    if guess > secret:
      if guess < upperbound:
        upperbound = guess
      print( f"High value. The number is between {lowerbound} and " + f"{upperbound} \n"  )

    # The Guess is lower than actual
    if guess < secret:
      if guess > lowerbound:
        lowerbound = guess
      print( f"Low value. The number is between {lowerbound} and " + f"{upperbound} \n"  )