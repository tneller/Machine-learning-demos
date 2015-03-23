####Information retrieval

Information retrieval: given a set of documents, pull up the k most similar documents to a given query.

* Bag-of-words: list all the words and how many times they appeared
* Similarity measures:
  * Euclidean distance
  * Manhattan distance
* Normalization: deal with different document length
* Inverse document frequency (IDF): reduce the weight of common words 
* Stemming: reduce all similar words to one stem word

But what if documents are webpages, and our collection is the whole web. These techniques become computationally infeasible at this scale.

####PageRank

We measure the importance of a webpage __w__ by its PageRank score, which is based on its linking webpages. However, we don’t want to treat all linking webpages equally. So we weight the links as follow:
  * Webpages that link to __w__, and have high PageRank scores themselves, should be given more weight
  * Webpages that link to __w__, but link to a lot of other webpages ingeneral, should be given less weight

Based on this scoring system, we can let webpages vote for each other and properly measure the importance of each webpage. However, this still don't work because sometimes webpages are not strongly connected. So we can modify the algorithm a little bit, which is at most of the time, we perform the linking rating, but we assume there are random surfer doing random jump sometime. This random jump makes all webpages connected.
