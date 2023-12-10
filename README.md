Before running tests on your machine:
1. Create an account on browserstack.com (if you don't have one)
2. Copy access key data: "user name" and "access key"
3. Change user_name and access_key data in the auth.properties file, put them from the step 2.

Now you are ready to run tests! 
- use command `gradle clean ios_test -Dplatform=ios` to run ios tests
- use command `gradle clean android_test -Dplatform=android` to run android tests
