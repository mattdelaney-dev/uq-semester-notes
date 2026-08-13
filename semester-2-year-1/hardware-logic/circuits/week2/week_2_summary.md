# CSSE2010 Week 2 — Compressed Cheat Sheet

## 1. The core simplification moves (spot these first)

These four patterns cover almost every simplification you'll see:

| Pattern | Rule | Example from tonight |
|---|---|---|
| **Factor + cancel** | `XY + XY′ = X(Y+Y′) = X` | Q5(a), practice Q1 |
| **Distributive reverse** | `(A+B)(A+C) = A + BC` | Q11(a): `(X+Y)(X+Y′) = X` |
| **Absorption** | `A + A′B = A + B` | Q5(c) step 1: `D′+C′D = D′+C′` |
| **Complementary product = 0** | anything · `X·X′` = 0 | Q5(b): whole expression collapsed to 0 |

**The tell for "0 or 1" answers:** if every cross-term in an expansion contains a variable ANDed with its own complement, the whole thing collapses to `0`. If a chain of terms keeps hitting `X+X′=1`, it collapses toward `1` or a single surviving variable.

**Double-collapse pattern** (came up in Q5c, practice Q3, Q4): factor once → get `X+X′=1` → left with a smaller expression → factor again → get `X+X′=1` again → down to one variable. Always check if you can repeat the trick after the first simplification.

## 2. Boolean identity table (from lecture)

| Name | AND form | OR form |
|---|---|---|
| Identity | `1·X = X` | `0+X = X` |
| Null | `0·X = 0` | `1+X = 1` |
| Idempotent | `X·X = X` | `X+X = X` |
| Inverse | `X·X′ = 0` | `X+X′ = 1` |
| Distributive | `X+YZ = (X+Y)(X+Z)` | `X(Y+Z) = XY+XZ` |
| Absorption | `X(X+Y) = X` | `X+XY = X` |
| De Morgan | `(XY)′ = X′+Y′` | `(X+Y)′ = X′Y′` |
| XOR (SOP) | `X⊕Y = XY′+X′Y` | |
| XNOR (SOP) | `X⊕Y′ = XY+X′Y′` | |

**Complementing an expression** = apply De Morgan recursively, outside-in: flip every AND↔OR, complement every literal, one layer at a time (Q9).

## 3. Counting Boolean functions

- n variables → truth table has `2ⁿ` rows → `2^(2ⁿ)` possible functions.
- n=1: 4 functions. n=2: 16 functions. n=3: 256 functions.
- **Why:** each row's output is independently 0 or 1, so it's "how many ways to fill 2ⁿ output slots" = 2^(2ⁿ).

## 4. From truth table → circuit (the universal method)

1. Write SOP: one AND term per row where output=1, OR them all together.
2. This always gives a **two-level AND-OR circuit**: layer of AND gates (one per term) → one OR gate.
3. Simplify algebraically to cut literals = cut gate inputs.
4. **Complemented literals need their own inverter** — but a repeated complement (e.g. X′ used in two different AND gates) only needs ONE inverter, shared.

## 5. Universal / complete gates

- **NAND alone** or **NOR alone** can build any circuit (NOT, AND, OR — see Lab 2 slide 23).
- Two ways to build an "all inputs match" comparator — same function, different factoring:
  - `AND of XNORs` (match-based)
  - `NOR of XORs` (difference-based)
  - Connected by De Morgan: `AND(NOT xᵢ) = NOT(OR xᵢ)`
  - **If a diagram is given, reproduce what's shown — don't silently swap in the "equivalent" version.**

## 6. Multiplexer (MUX) — the big idea

- n select lines → 2ⁿ data inputs → 1 output.
- Function table: read select lines as binary number → that's the index of the Di that passes through.
- **Gate circuit**: one AND gate per data line (gated by its unique select combo) → one big OR gate. Exactly the SOP-to-circuit method from §4.
- **4-to-1 MUX = universal 2-variable function generator**: wire the 2 variables to the select lines, hardwire D0–D3 to the target function's truth table column (as 0/1 constants). Works for ALL 16 two-variable functions (Q13) — no exceptions.
- **Full adder from two 4-to-1 MUXes** (Q17): same idea, one MUX per output (S and Cout), inputs A,B select, Cin (and constants) as data lines.

## 7. Full adder — recognize by pattern, not decimal conversion

- Inputs A, B, Cin. Add them as a 2-bit binary sum: **Cout = high bit, S = low bit**.
- Shortcut without doing binary conversion each time:
  - **Cout = 1 whenever ≥2 of {A,B,Cin} are 1**
  - **S = 1 whenever an ODD number of {A,B,Cin} are 1** (S is literally `A⊕B⊕Cin`)
- SOP: `Cout = AB + ACin + BCin` (3 literals×3 terms, simplifies nicely from the 4-term minterm expansion)
- `S = A⊕B⊕Cin` — doesn't simplify further via normal algebra, it's inherently the odd/XOR function.

## 8. Comparator (equality checker)

- Per-bit: **XNOR** = "do these two bits match?" (`AB+A′B′`)
- Combine 8 bits: **AND** all 8 XNOR outputs → 1 only if ALL bits match.
- Equivalent alt build: **XOR** per bit ("do they differ?") → **NOR** all 8 → same result via De Morgan.

## 9. Two's complement / overflow quick rules

- Overflow (signed): sign bits of both operands equal, but result's sign bit differs. Equivalently: **carry-in to MSB ≠ carry-out of MSB**.
- Overflow (unsigned): carry-out of MSB = 1.
- To negate: flip all bits, add 1.

## 10. Study habit note

You keep catching notation issues fast (dropped complement bars, gate-type mismatches) — that pattern-recognition instinct is exactly what carries into exams where there's no PDF to double check against. Trust it, but for anything gate-diagram-specific on an assessment, always double check against the *exact* diagram given rather than an equivalent you've derived.