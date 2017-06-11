Random.org api generates a maximum of 10000 numbers. A 128 * 128 has around 16000 pixels. 
I make two api requests. The response has around 8000 random numbers one on each line. 
Then I parse the string and generate pixel value of alpha, red, blue and green channels.

If there is an error in the api response, the program generates an equivalent string instead which will be used to generate the image

References:
https://www.dyclassroom.com/image-processing-project/how-to-create-a-random-pixel-image-in-java
https://stackoverflow.com/questions/381037/true-random-generation-in-java
https://stackoverflow.com/questions/7467568/parsing-json-from-url
https://www.random.org/clients/http/#integers	
