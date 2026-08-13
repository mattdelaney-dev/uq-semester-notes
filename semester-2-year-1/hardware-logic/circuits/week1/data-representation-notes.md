# CSSE2010/CSSE7201 — Week 1 Notes
## Bits, Bytes & Binary; Intro to Logic Gates

---

## Q1. Decimal → binary (unsigned)

Method: repeated division by 2, read remainders bottom-to-top.

- **1984** → `11111000000`
  (check: 1024+512+256+128+64 = 1984 ✓)
- **4000** → `111110100000`
  (check: 2048+1024+512+256+128+32 = 4000 ✓)
- **8192** → `10000000000000`
  (8192 = 2¹³ exactly, so it's just a 1 followed by thirteen 0s)

---

## Q2. `1001101001` (binary, unsigned) → decimal, octal, hex

**To decimal:** sum the powers of 2 where the bit is 1.
512 + 64 + 32 + 8 + 1 = **617**

**To octal:** group bits in 3s from the right, pad the leftmost group with zeros.
`1 001 101 001` → `001 001 101 001` → **1 1 5 1** → **1151₈**
(check: 1·512 + 1·64 + 5·8 + 1 = 617 ✓)

**To hex:** group bits in 4s from the right, pad with zeros.
`0010 0110 1001` → **2 6 9** → **0x269**
(check: 2·256 + 6·16 + 9 = 617 ✓)

*Why grouping works:* octal (base 8 = 2³) and hex (base 16 = 2⁴) are both powers of 2, so each group of 3 (or 4) bits maps directly to exactly one octal (or hex) digit — no arithmetic conversion needed, just grouping and lookup.

---

## Q3. How many positive integers can be expressed in *k* digits, radix *r*?

Each of the *k* digit positions can independently take any of *r* values (0 to r−1), so the total number of distinct combinations is:

**r^k**

This counts every value from 0 up to r^k − 1 (i.e. r^k different integers total, including zero as one of the representable values).

---

## Q4. Manchester Mark 1 — radix-32 numbers

Digits used: `0–9` then `A–V` (10 + 22 = 32 symbols, representing values 0–31).

**(a) Binary → radix-32:**
Since 32 = 2⁵, group the binary number into sets of **5 bits** starting from the right (pad the leftmost group with zeros if needed). Each 5-bit group is a value 0–31, which maps directly to one radix-32 digit — exactly the same idea as grouping into 4s for hex, just with groups of 5 instead.

**(b) Decimal → radix-32:**
Repeatedly divide by 32, keeping the remainder each time. Convert each remainder (0–31) to its corresponding digit (0–9, then A=10 up to V=31). Read the digits from the **last remainder to the first** (i.e. bottom-to-top, same process as decimal→binary but dividing by 32 instead of 2).

**(c) Convert 1300 and 2300:**

*1300:*
- 1300 ÷ 32 = 40 remainder **20** → digit `K`
- 40 ÷ 32 = 1 remainder **8** → digit `8`
- 1 ÷ 32 = 0 remainder **1** → digit `1`
- Read bottom-to-top: **1300 = "18K"**
- Check: 1·32² + 8·32 + 20 = 1024 + 256 + 20 = 1300 ✓

*2300:*
- 2300 ÷ 32 = 71 remainder **28** → digit `S`
- 71 ÷ 32 = 2 remainder **7** → digit `7`
- 2 ÷ 32 = 0 remainder **2** → digit `2`
- Read bottom-to-top: **2300 = "27S"**
- Check: 2·32² + 7·32 + 28 = 2048 + 224 + 28 = 2300 ✓

---

## Q5. Largest unsigned integer representable

General rule: with *n* digits in base *b*, the largest value is **bⁿ − 1**.

- **(a) 10 bits:** 2¹⁰ − 1 = **1023**
- **(b) 9 decimal digits:** 10⁹ − 1 = **999,999,999**
- **(c) 8 hexadecimal digits:** 16⁸ − 1 = 0xFFFFFFFF = **4,294,967,295**

---

## Q6. Counting on ten fingers (2 positions each)

Each finger = one bit (up/down). 10 fingers = 10 bits → same setup as Q5(a).

**Largest count = 2¹⁰ − 1 = 1023**

This is "finger binary" — each finger represents a power of 2 (1, 2, 4, 8, 16 ...) instead of counting to 10 one at a time.

---

## Q7. Signed number representations (8-bit)

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

One's complement has **two zeros** (`00000000` and `11111111`), wasting a pattern and complicating arithmetic. Adding 1 after flipping removes the second zero:

- +0 = `00000000` → flip → `11111111` (would be "–0") → add 1 → `100000000` → overflow bit drops (only 8 bits) → `00000000`

Result: –0 becomes the same as +0. Only one zero, and plain binary addition works correctly across positive/negative values — why every modern CPU uses two's complement internally.

### Decoding back to decimal (example: `11111111`)

- **Signed magnitude:** sign bit 1 (negative), magnitude `1111111` = 127 → **–127**
- **One's complement:** flip all bits → `00000000` = 0 → **–0** (i.e. 0)
- **Two's complement:** flip (`00000000`), add 1 (`00000001`) → **–1**
- **Excess-128:** read as unsigned = 255, subtract 128 → **+127**

Same bit pattern, four completely different values depending on the format.

---

## Q8. Range formulas for n-bit signed formats

- **(a) 16-bit two's complement:** range is **–2ⁿ⁻¹ to +2ⁿ⁻¹ – 1**
  → –32,768 to +32,767 (asymmetric — one extra negative value, since there's only one zero)

- **(b) n-bit one's complement:** range is **–(2ⁿ⁻¹ – 1) to +(2ⁿ⁻¹ – 1)**
  (symmetric — a pattern is "wasted" on both +0 and –0)

- **(c) Excess-2ᵐ⁻¹ (m bits):** range is **–2ᵐ⁻¹ to +2ᵐ⁻¹ – 1**
  (same shape as two's complement — stored value = actual value + bias)

---

## Q9. Logic gates

### (a) 4-input NOR gate

**Boolean function:** F = (A + B + C + D)′ = A̅·B̅·C̅·D̅ (De Morgan's)

Output is 1 only when **all** inputs are 0.

**Symbol:** OR-gate shape (curved back, tapering to a point) with a small bubble (circle) at the output to indicate negation. Four input lines on the left, one output line from the bubble.

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

### (b) 3-input XOR gate (odd function)

**Boolean function:** F = A ⊕ B ⊕ C

Output is 1 whenever an **odd number** of inputs are 1 — hence "odd function."

**Symbol:** same OR-gate shape, but with an extra curved line just before the inputs (this extra curve distinguishes XOR from plain OR). No bubble (not inverted). Three input lines, one output.

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

---

## Self-test

Work through these without looking back at the notes, then check against the methods/formulas above.

1. Convert 2500 to unsigned binary.
2. Convert `110101110` (binary, unsigned) to decimal, octal, and hex.
3. How many different positive integers can be expressed in 5 digits using radix 8?
4. Using the Manchester Mark 1's radix-32 digits (0–9, A–V), convert decimal 700 to radix-32.
5. What's the largest unsigned integer representable in 12 bits? In 6 hex digits?
6. Write –5 in 8-bit signed magnitude, one's complement, two's complement, and excess-128.
7. Why does two's complement only have one representation of zero, while one's complement has two?
8. Decode the 8-bit pattern `10000000` in each of the four formats (signed magnitude, one's complement, two's complement, excess-128).
9. What is the range of values representable in 12-bit two's complement? In 5-bit one's complement?
10. Write the Boolean function and truth table for a 3-input NOR gate.
11. Write the Boolean function and truth table for a 4-input XOR (odd) gate.
12. True or false: the bit pattern for –1 in two's complement is the same as the largest unsigned value using the same number of bits. Explain why.

*(No answer key included on purpose — work through them and check against the methods above.)*