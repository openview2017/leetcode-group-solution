class PasswordStrength:
    def getStrength(self, password):
        vowel = {'a','e','i','o','u'}
        vowel_status = False
        consonant_status = False
        strength = 0
        for i in password:
            if i in vowel:
                vowel_status = True
            else:
                consonant_status = True
            if vowel_status and consonant_status:
                strength += 1
                vowel_status = False
                consonant_status = False
        return strength

if __name__ == "__main__":
    # Test case1
    password = "hackerrank" 
    ps = PasswordStrength()
    print(ps.getStrength(password))
    print("Expected result: {}".format(3))