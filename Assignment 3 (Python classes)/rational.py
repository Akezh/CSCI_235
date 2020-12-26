from numbers import *

def gcd(n1, n2):
  if n1 == 0 and n2 == 0:
    raise ArithmeticError("gcd(0,0) does not exist")

  if n2 > n1:
    n1, n2 = n2, n1
    
  while n2 != 0:
    r = n1 % n2
    n1, n2 = n2, r
  
  if n1 < 0:
    n1 *= -1
  
  return n1

class Rational( Number ):
  def __init__(self, num, denom = 1):
    if not isinstance(num, Integral):
      raise TypeError("Rational: numerator {} must be Integral".format(num))
    if not isinstance(denom, Integral):
      raise TypeError( "Rational: denominator {} must be Integral".format(denom))
    
    self.num = num
    self.denom = denom
    self.normalize()

  def normalize(self): 
    divisor = gcd(self.num, self.denom)
    self.num = self.num // divisor
    self.denom = self.denom // divisor

    if self.denom < 0:
      self.num *= -1
      self.denom *= -1
  
  def __repr__(self):
    return "Rational( {}, {} )".format(self.num, self.denom)

  def __str__(self):
    if self.denom == 1:
      return str(self.num)
    
    return "{} / {}".format(self.num, self.denom)

  def __neg__(self):
    return Rational(self.num * (-1), self.denom)

  def __add__(self, other):
    if not isinstance(other, Rational):
      other = Rational(other, 1)
    
    return Rational(self.num * other.denom + other.num * self.denom, self.denom * other.denom)

  def __sub__(self, other):
    if not isinstance(other, Rational):
      other = Rational(other, 1)
    
    return Rational(self.num * other.denom - other.num * self.denom, self.denom * other.denom)

  def __radd__(self, other):
    if not isinstance(other, Rational):
      other = Rational(other, 1)
    
    return Rational(self.num * other.denom + other.num * self.denom, self.denom * other.denom)
    
  def __rsub__(self, other):
    if not isinstance(other, Rational):
      other = Rational(other, 1)
    
    return Rational(other.num * self.denom - self.num * other.denom, self.denom * other.denom)

  def __mul__(self, other):
    if not isinstance(other, Rational):
      other = Rational(other, 1)
    
    return Rational(self.num * other.num, self.denom * other.denom)

  def __truediv__(self, other):
    if not isinstance(other, Rational):
      other = Rational(other, 1)

    return Rational(self.num * other.denom, self.denom * other.num)

  def __rmul__(self, other):
    if not isinstance(other, Rational):
      other = Rational(other, 1)
    
    return Rational(other.num * self.num, other.denom * self.denom)

  def __rtruediv__(self, other):
    if not isinstance(other, Rational):
      other = Rational(other, 1)

    return Rational(other.num * self.denom, other.denom * self.num)

  def __eq__(self, other):
    if not isinstance(other, Rational):
      other = Rational(other, 1)

    return self.num == other.num and self.denom == other.denom

  def __ne__(self, other):
    if not isinstance(other, Rational):
      other = Rational(other, 1)

    return self.num != other.num or self.denom != other.denom

  def __lt__(self, other):
    if not isinstance(other, Rational):
      other = Rational(other, 1)

    return (self.num/self.denom) < (other.num/other.denom)

  def __gt__(self, other):
    if not isinstance(other, Rational):
      other = Rational(other, 1)

    return (self.num/self.denom) > (other.num/other.denom)

  def __le__(self, other):
    if not isinstance(other, Rational):
      other = Rational(other, 1)

    return (self.num/self.denom) <= (other.num/other.denom)

  def __ge__(self, other):
    if not isinstance(other, Rational):
      other = Rational(other, 1)

    return (self.num/self.denom) >= (other.num/other.denom)

  def getfloat( self ) :  
    return self.num / self.denom


def summation( it, x ) :
  sum = 0
  xpow = 1
  
  for coeff in it:
    sum = sum + xpow * coeff
    xpow *= x
  
  return sum

print(summation([1,2,3,2,1,21,1,4], Rational(2,16)))
print(summation([1,2,3,2,1,21,1,4], Rational(2,16) ). getfloat( ))
print(summation([1,2,3,2,1,21,1,4], 2/16 ))
