# Formula Checker
Created: May 2017

An algorithm written over the summer to validate formulas. Note that this only validates a formula and does not solve it. A formula can contain any number of nested expressions, surrounded by both parentheses and brackets. Additionally, a formula can contain any number of standard operations from the typical operation set (+-\*/). Formulas are also allowed to contain negative numbers, and of course integers as well as decimal digits. All of the above must be syntactically correct, i.e. no mismatched braces. As of now, the algorithm is not programmed to allow for non-numerical variables. The algorithm allows for implicit multipication, i.e **(4)(3)** is valid because it is implied that it is a multiplicative operation. The algorithm does not allow for trailing decimal places, so the number **500.** is not valid because the decimal is not followed by a value, however this can easily be changed.     


This was done just to see if I could, because it seemed like a tricky problem. I wanted to see if it could be done in one pass through and was mostly successful. I decided to implement a recursive function call to validate nested parenthetical expressions. However, under ideal circumstances the algorithm would be O(N). 
