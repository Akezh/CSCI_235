def geometric(a0, an, c):
  cur = a0
  while cur < an:
    yield cur
    cur *= c

def divisors(n):
  cur = 2
  while cur <= n:
    if n % cur == 0:
      temp = n

      while temp >= cur:
        if temp % cur == 0:
          yield cur
          temp /= cur
          continue
        break

    cur += 1

def filter(sel, other):
  while True:
    try:
      cur = next(other)
      if sel(cur) == True:
        yield cur
    except StopIteration:
      return

n = 3
primit = filter( lambda p : len( list( divisors(p))) == 1, divisors(n))
prod = 1
for i in primit:
  prod = prod * i
  print( prod, n )


def permutations(n):
  if n == 0:
    yield []
  else:
    for i in range(n):
      li = [i]
      for it in permutations(n-1):
        li.insert(i, it)
        yield li