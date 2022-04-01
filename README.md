# domain-name-converter
This project provide 2 api endpoints:
1. convert a long domain name to short domain name. 

   when pass long domain name in the parameter, it can return the encoded short domain name 

   `curl --location --request GET '/domain/encode?longName={longName}'`

2. locate the long domain name given a short domain name
   
   when pass encoded short domain name in the parameter, it can return the original long domain name.
   if the decoded short domain name cannot be found in system, it will return NOT_FOUND status code.
      `curl --location --request GET 'localhost:8888/domain/decode?shortName={shortName}'`
