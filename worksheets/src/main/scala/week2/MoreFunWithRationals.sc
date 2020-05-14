import week2.Rational

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)

x.numer
x.denom

x.sub(y).sub(z)
x - y - z
y.add(y)
y + y
x.less(y)
x < y
x.max(y)
new Rational(2)