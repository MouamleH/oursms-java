

# oursms java

http://oursms.app client library

## Installation 

Get the project from jitpack

[![](https://jitpack.io/v/MouamleH/oursms-java.svg)](https://jitpack.io/#MouamleH/oursms-java)

or directly from here
```xml 
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.MouamleH</groupId>
        <artifactId>oursms-java</artifactId>
        <version>0.0.1</version>
    </dependency>
</dependencies>
```
    
## Usage/Examples

First you create a client with your api credentials
```java
OursmsClient client = new OursmsClient(<USER-ID>, <API-KEY>);
```

Then you can send messages as follows

### Normal Message
```java
try {
    final Optional<SentMessageData> oSentMessageData = client.sendOneMessage(<MOBILE-NUMBER, <MESSAGE-TEXT>);
    if (oSentMessageData.isPresent()) {
        final SentMessageData sentMessageData = oSentMessageData.get();
        // store message id to check status later if you want
    }
} catch (IOException e) {
    // handle exception
}
```

### OTP Message
Here you send the otp as an integer and the api takes care of appending it to a message body
```java
try {
    final Optional<SentMessageData> oSentMessageData = client.sendOTP(<MOBILE-NUMBER, <OTP>);
    if (oSentMessageData.isPresent()) {
        final SentMessageData sentMessageData = oSentMessageData.get();
        // store message id to check status later if you want
    }
} catch (IOException e) {
    // handle exception
}
```

### Message Status
```java
try {
    final List<MessageStatus> messageStatus = client.getMessageStatus(<MESSAGE-ID>);
    // This list typically contains only one element
} catch (IOException e) {
    // handle exception
}
```
