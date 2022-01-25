# Password strength

Your team at Amazon has recently adopted a new password validationscheme for internal user accounts.

A password consists of lowercase English letters only and is valid only if it contains at least one vowel and at least one consonant. Vowels are the characters 'a', 'e', i', 'o'and 'u'. The rest are consonants. The strength of a password is defined as the maximum number of contiguous subsegments the entire password can be divided into such that each subsegment is a valid password.

Given a password string, find its strength. Return O if the password itself is not valid.

**Note:** A subsegment of a string is a segment composed of contiguous characters of the original string, taken in the same order.

**Example**
password = "hackerrank"
This password can be divided into 3 subsegments: "hack", "er", and "rank". Each segment contains at least one vowel and one consonant.

It can be shown that the string cannot be divided into more than 3 valid subsegments. The strength of the password is 3.

**Function Description**
Complete the function *findPasswordStrength* in the editor below.

*findPasswordStrength* has the following parameter(s):
    *string password*: the given password

**Returns**
    int: the strength of the password

**Constraints**
- 1 ≤ *|password|* ≤ 10^5 (the length of *password*)
- *password* consists of lowercase English letters only.