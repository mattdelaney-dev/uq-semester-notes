# Data Representation & Logic Gates — Study Notes

---

## 1. Largest unsigned integer representable

General rule: with *n* digits in base *b*, the largest value is **bⁿ − 1**.

- **(a) 10 bits:** 2¹⁰ − 1 = **1023**
- **(b) 9 decimal digits:** 10⁹ − 1 = **999,999,999**
- **(c) 8 hexadecimal digits:** 16⁸ − 1 = 0xFFFFFFFF = **4,294,967,295**

---

## 2. Counting on ten fingers (2 positions each)

Each finger = one bit (up/down). 10 fingers = 10 bits → same as 1(a).

**Largest count = 2¹⁰ − 1 = 1023**

This is "finger binary" — each finger represents a power of 2 (1, 2, 4, 8, 16...) instead of just counting to 10 one at a time.

---

## 3. Signed number representations (8-bit)

| Format | How to build it |
|---|---|
| Signed magnitude | Leftmost bit = sign (1 = negative), remaining 7 bits = binary magnitude |
| One's complement | Take the positive binary value, flip every bit |
| Two's complement | Take one's complement, then **add 1** |
| Excess-128 | Add 128 to the number, write result as plain 8-bit unsigned binary |

### Worked examples

**(a) –1**
- Signed magnitude: `10000001`
- One's complement: `11111110`
- Two's complement: `11111111`
- Excess-128: `01111111`

**(b) –16**
- Signed magnitude: `10010000`
- One's complement: `11101111`
- Two's complement: `11110000`
- Excess-128: `01110000`

**(c) –99**
- Signed magnitude: `11100011`
- One's complement: `10011100`
- Two's complement: `10011101`
- Excess-128: `00011101`

### Why two's complement adds 1

One's complement has **two zeros** (`00000000` and `11111111`), which wastes a pattern and complicates arithmetic. Adding 1 after flipping removes the second zero:

- +0 = `00000000`
- Flip → `11111111` (would be "–0" in one's complement)
- Add 1 → `100000000` → overflow bit drops off (only 8 bits) → `00000000`

Result: –0 becomes the same as +0. Only one zero, and plain binary addition works correctly even across positive/negative values — this is why every modern CPU uses two's complement internally.

### Decoding back to decimal (example: `11111111`)

- **Signed magnitude:** sign bit 1 (negative), magnitude `1111111` = 127 → **–127**
- **One's complement:** flip all bits → `00000000` = 0 → **–0** (i.e. 0)
- **Two's complement:** flip all bits (`00000000`), add 1 (`00000001`) → **–1**
- **Excess-128:** read as unsigned = 255, subtract 128 → **+127**

Same bit pattern, four completely different values depending on the format — that's the core lesson of this topic.

---

## 4. Range formulas for n-bit signed formats

- **(a) 16-bit two's complement:** range is **–2ⁿ⁻¹ to +2ⁿ⁻¹ – 1**
  → –32,768 to +32,767 (asymmetric — one extra negative value, since there's only one zero)

- **(b) n-bit one's complement:** range is **–(2ⁿ⁻¹ – 1) to +(2ⁿ⁻¹ – 1)**
  (symmetric — a pattern is "wasted" on both +0 and –0)

- **(c) Excess-2ᵐ⁻¹ (m bits):** range is **–2ᵐ⁻¹ to +2ᵐ⁻¹ – 1**
  (same shape as two's complement — stored value = actual value + bias)

---

## 5. Logic gates

### (a) 4-input NOR gate

**Boolean function:** F = (A + B + C + D)′ = A̅·B̅·C̅·D̅ (De Morgan's)

Output is 1 only when **all** inputs are 0.

| A | B | C | D | F |
|---|---|---|---|---|
| 0 | 0 | 0 | 0 | **1** |
| 0 | 0 | 0 | 1 | 0 |
| 0 | 0 | 1 | 0 | 0 |
| 0 | 0 | 1 | 1 | 0 |
| 0 | 1 | 0 | 0 | 0 |
| 0 | 1 | 0 | 1 | 0 |
| 0 | 1 | 1 | 0 | 0 |
| 0 | 1 | 1 | 1 | 0 |
| 1 | 0 | 0 | 0 | 0 |
| 1 | 0 | 0 | 1 | 0 |
| 1 | 0 | 1 | 0 | 0 |
| 1 | 0 | 1 | 1 | 0 |
| 1 | 1 | 0 | 0 | 0 |
| 1 | 1 | 0 | 1 | 0 |
| 1 | 1 | 1 | 0 | 0 |
| 1 | 1 | 1 | 1 | 0 |

Symbol: OR-gate shape with a small bubble (circle) at the output to indicate negation. Four input lines on the left, one output line from the bubble.

### (b) 3-input XOR gate (odd function)

**Boolean function:** F = A ⊕ B ⊕ C

Output is 1 whenever an **odd number** of inputs are 1 — hence "odd function."

| A | B | C | # of 1s | F |
|---|---|---|---|---|
| 0 | 0 | 0 | 0 (even) | 0 |
| 0 | 0 | 1 | 1 (odd) | **1** |
| 0 | 1 | 0 | 1 (odd) | **1** |
| 0 | 1 | 1 | 2 (even) | 0 |
| 1 | 0 | 0 | 1 (odd) | **1** |
| 1 | 0 | 1 | 2 (even) | 0 |
| 1 | 1 | 0 | 2 (even) | 0 |
| 1 | 1 | 1 | 3 (odd) | **1** |

Symbol: same OR-gate shape, but with an extra curved line just before the inputs (this extra curve is what distinguishes XOR from plain OR). No bubble (not inverted). Three input lines, one output.

---

## Self-test

Try these without looking back at the notes above, then check your work.

1. What's the largest unsigned integer representable in 12 bits?
2. What's the largest unsigned integer representable in 6 hexadecimal digits?
3. Write –5 in 8-bit signed magnitude, one's complement, two's complement, and excess-128.
4. Why does two's complement only have one representation of zero, while one's complement has two?
5. Decode the 8-bit pattern `10000000` in each of the four formats (signed magnitude, one's complement, two's complement, excess-128).
6. What is the range of values representable in 12-bit two's complement?
7. What is the range of values representable in 5-bit one's complement?
8. Write the Boolean function and truth table for a 3-input NOR gate.
9. Write the Boolean function and truth table for a 4-input XOR (odd) gate.
10. True or false: the bit pattern for –1 in two's complement is the same as the largest unsigned value using the same number of bits. Explain why.

*(No answer key included on purpose — work through them and check against the formulas/methods above.)*
