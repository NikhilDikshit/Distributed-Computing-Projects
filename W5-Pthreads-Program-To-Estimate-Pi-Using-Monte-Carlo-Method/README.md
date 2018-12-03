## Monte Carlo Method:

Suppose we toss darts randomly at a square dartboard, whose bullseye is at the origin, and whose sides are 2 feet in length. Suppose also that there’s a circle inscribed in the square dartboard. The radius of the circle is 1 foot, and it’s area is π square feet. If the points that are hit by the darts are uniformly distributed (and we always hit the square), since the ratio of the area of the circle to the area of the square is π/4, the number of darts that hit inside the circle should approximately satisfy the equation:
```
number_in_circle / total_number_of_tosses = π / 4
```
We can use this formula to estimate the value of π with a random number
generator:
```
number in circle = 0;
for (toss = 0; toss < number of tosses; toss++) {
	x = random double between − 1 and 1;
	y = random double between − 1 and 1;
	distance squared = x∗x + y∗y;
	if (distance squared <= 1) 
		number in circle++;
}
pi estimate = 4∗number in circle/((double) number of tosses);
```
This is called a “Monte Carlo” method, since it uses randomness (the dart
tosses).
