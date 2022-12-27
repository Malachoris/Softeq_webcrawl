# Softeq_webcrawl

1. Download all files and put in one folder
2. Run with smart IDEA like IntelliJ
3. Wait for dependencies to download
4. Run the SpringBoot application
5. Navigate to your browser and use some SOAP/REST API client I used Talend API Tester
6. Make sure your view is identical to the picture bellow:
![Screenshot from 2022-12-27 04-33-49](https://user-images.githubusercontent.com/67054199/209607223-e5c1b05b-54db-4e0d-92f6-be2d8032ed03.png)
7. Data will start populating once you hit button "HIT ME"
8. You can check dataentries live populating at navigating in your browser and typing localhost:8080/h2-console
9. Once you there username should be set to SA and no need for password, also db name should be set to jdbc:h2:mem:webcrawler
![image](https://user-images.githubusercontent.com/67054199/209607671-cd85e77c-1c5b-4bb4-84a0-464e26715dbe.png)
10. Once you in click buttons 1 and 2 to see populating data
![Screenshot from 2022-12-27 04-34-15](https://user-images.githubusercontent.com/67054199/209607691-945115c5-1177-450d-a21d-3cf4abb7d253.png)
11. At this point we will have quite some data already so we can navigate back to Talend API tester and try out GET method
![Screenshot from 2022-12-27 04-39-04](https://user-images.githubusercontent.com/67054199/209607892-77ffdc22-c7e8-4e23-b6c8-ee2e157a5366.png)
12. In the example we asked to get us top 10 pages with most hits of our terms we were looking for
![Screenshot from 2022-12-27 04-38-50](https://user-images.githubusercontent.com/67054199/209607987-93dfa37e-06f9-4628-aa15-1c2e15e58a1f.png)

This REST API project was done for the purpose of learning. It can be improved a great deal.
