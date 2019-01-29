Question C README: 

For question C, I have decided to simply discuss my ideas to solve this problem. Alongside this I am submitting a JAVA LRU cache implementation, as shown in the provided LRUCache.java files. Please note however, that that solution is copied from https://java2blog.com/lru-cache-implementation-java/. 

It is my understanding that there is one centralized database/cache that stores all the information and then writes the information to the other caches. 

I would build upon the Java LRU cache implementation to meet the needs of Ormuco. Firstly, the Node class could easily be changed such that it would contain the information (keys, values) needed in the cache. This will ensure data consistency when replicated. Next, in the Node class, I would add an expiration field to know when the cached item is expired. You could create a function/script which checks the cache every x amount of time to purge any expired entries. Java has a lot of libraries which can make this job easier. In your main database, you can also keep track of when the actual cache expires, in order to purge it.

Furthermore, you would create another automatic trigger/script which is used to replicate the data from the main database to the other caches. A copy of all the cached information should be stored offline in case there is a network failure so that the information can be readily made available afterwards. Configurations should be made on the user's end such that data is retrieved from the closest location, and should the network fail, the data should be retrieved from the next closest location. 
