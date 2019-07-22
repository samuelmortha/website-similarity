# website-similarity
# cisco-jaccard-index
Code challenge for Cisco interview.

================== REMOVE SYSOUTS IN THE CODE 

RUN the application as WebService and test :-) ===================


The Jaccard index, also known as Intersection over Union, is a statistic used for gauging the similarity and diversity of sample sets. 
The Jaccard coefficient measures similarity between finite sample sets, 
and is defined as the size of the intersection divided by the size of the union of the sample sets:

J(A,B)	= |A intersection B| / |A union B| 
		= |A intersection B| / |A| + |B| - |A intersection B|
		
(If A and B are both empty, we define J(A,B) = 1.)

	0 <= J(A,B) <= 1

** Source : Wikipedia (https://en.wikipedia.org/wiki/Jaccard_index)

http://localhost:8080/website-similarity?url1=http://www.google.com&url2=https://www.bing.com

http://localhost:8080/website-similarity?url1=http://www.google.com&url2=https://www.google.com

http://localhost:8080/website-similarity?url1=https://www.encyclopedia.com/places/united-states-and-canada/us-political-geography/united-states&url2=https://en.wikipedia.org/wiki/United_States

http://localhost:8080/website-similarity?url1=https://en.wikipedia.org/wiki/Horse&url2=https://en.wikipedia.org/wiki/Zebra

http://localhost:8080/website-similarity?url1=https://en.wikipedia.org/wiki/Mansion&url2=https://en.wikipedia.org/wiki/Bungalow

curl "http://localhost:8080/website-similarity?url1=https://en.wikipedia.org/wiki/Lemon&url2=https://en.wikipedia.org/wiki/Orange_(fruit)"
curl "http://localhost:8080/website-similarity?url1=https://en.wikipedia.org/wiki/Lemon&url2=https://en.wikipedia.org/wiki/Lemon"
https://en.wikipedia.org/wiki/Cisco_Systems