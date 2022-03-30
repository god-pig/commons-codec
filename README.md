# java hex

Easy hexadecimal encoding and decoding

# Usage

A simple usage example:

```java
class Example {
    public static void main(String[] args) {
        HexCodec hex = new HexCodec();
        hex.encode(new byte[]{1, 2, 3}); // "010203"
        hex.decode("010203"); // [1, 2, 3]
    }
}
```
