# website-similarity
Code challenge for Cisco interview.

Overview :

The Jaccard index, also known as Intersection over Union, is a statistic used for gauging the similarity and diversity of sample sets. 
The Jaccard coefficient measures similarity between finite sample sets, 
and is defined as the size of the intersection divided by the size of the union of the sample sets:

J(A,B)	= |A intersection B| / |A union B| 
		= |A intersection B| / |A| + |B| - |A intersection B|
		
(If A and B are both empty, we define J(A,B) = 1.)

	0 <= J(A,B) <= 1

** Source : Wikipedia (https://en.wikipedia.org/wiki/Jaccard_index)

Used jsoup : Java HTML Parser, java library.

Environment needed to run :

Java Version 8 or higher

Maven project management tool (v 3.3.9)

cURL or Postman tool for testing

Steps to run :

1. mvn clean package
2. mvn spring-boot:run

3. Use the below curl commands to test :
	
	curl "http://localhost:8080/website-similarity?url1=https://en.wikipedia.org/wiki/Lemon&url2=https://en.wikipedia.org/wiki/Orange_(fruit)"
	
	curl "http://localhost:8080/website-similarity?url1=https://en.wikipedia.org/wiki/Lemon&url2=https://en.wikipedia.org/wiki/Lemon"
	
	curl "http://localhost:8080/website-similarity?url1=https://en.wikipedia.org/wiki/Cisco_Systems&url2=https://en.wikipedia.org/wiki/Certis_Group"
	
	curl "http://localhost:8080/website-similarity?url1=https://en.wikipedia.org/wiki/Mansion&url2=https://en.wikipedia.org/wiki/Bungalow"

4. Postman tool can also be used with below GET URLs :

	http://localhost:8080/website-similarity?url1=https://en.wikipedia.org/wiki/Lemon&url2=https://en.wikipedia.org/wiki/Orange_(fruit)
	
	http://localhost:8080/website-similarity?url1=https://en.wikipedia.org/wiki/Lemon&url2=https://en.wikipedia.org/wiki/Lemon
	
	http://localhost:8080/website-similarity?url1=https://en.wikipedia.org/wiki/Cisco_Systems&url2=https://en.wikipedia.org/wiki/Certis_Group
	
	http://localhost:8080/website-similarity?url1=https://en.wikipedia.org/wiki/Mansion&url2=https://en.wikipedia.org/wiki/Bungalow

5. Ctrl+C to terminate the application.

Please email me at "sam.mortha@gmail.com" for any questions and comments.
