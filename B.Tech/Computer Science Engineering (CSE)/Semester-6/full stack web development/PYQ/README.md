# HTML Mid-Term Assignment – Web Development

> **Course:** Web Development | **Topic:** HTML Tags, IFrames, Frames, Forms, Image Maps & CSS

A complete set of practicals covering core HTML concepts including iframes, lists, tables, forms, frames, image maps, and CSS stylesheets.

---

## 📁 Project Structure

```
Web D Mid Term/
│
├── Part D – Iframe Questions
│   ├── q16_iframe_display.html       ← Q16: Display another HTML page via iframe
│   ├── q17_youtube_iframe.html       ← Q17: Embed YouTube video using iframe
│   ├── q18_page_a.html               ← Q18: Page A (loads Page B in iframe)
│   ├── q18_page_b.html               ← Q18: Page B (embedded child page)
│   ├── q19_iframe_dimensions.html    ← Q19: Iframe with height & width attributes
│   └── q20_nav_iframe.html           ← Q20: Navigation menu with iframe target
│
├── Lab Questions
│   ├── lab1_basic_tags.html          ← Lab 1: Basic HTML Tags
│   ├── lab2_list_table.html          ← Lab 2: Lists & Tables
│   ├── lab3_form.html                ← Lab 3: HTML Forms
│   ├── lab4_frames_iframes.html      ← Lab 4: Floating / Navigation / Mixed Frames
│   ├── lab5_image_map.html           ← Lab 5: Image Maps (circle, rect, poly, mixed)
│   ├── lab6_css_styles.html          ← Lab 6: Inline, Internal & External CSS
│   └── lab6_style.css                ← External CSS file for Lab 6
│
└── README.md
```

---

## 📋 Question Details

### Part D – IFrame Tag Questions

| # | File | Description |
|---|------|-------------|
| Q16 | `q16_iframe_display.html` | Displays `q18_page_b.html` inside an `<iframe>` |
| Q17 | `q17_youtube_iframe.html` | Embeds a YouTube video using iframe's `src` |
| Q18 | `q18_page_a.html` + `q18_page_b.html` | Two pages; Page A loads Page B in an iframe |
| Q19 | `q19_iframe_dimensions.html` | Shows iframes with small, medium, and large `width`/`height` |
| Q20 | `q20_nav_iframe.html` | Sidebar nav menu using `target="frame-name"` to load pages into a named iframe |

### Lab Questions

| # | File | Description |
|---|------|-------------|
| Lab 1 | `lab1_basic_tags.html` | Headings, paragraphs, bold, italic, underline, links, images, `<hr>`, `<br>`, blockquote, `<pre>` |
| Lab 2 | `lab2_list_table.html` | Unordered, ordered, nested & definition lists; simple table; seminar schedule table with `colspan` & `rowspan` |
| Lab 3 | `lab3_form.html` | Complete registration form: text, email, password, number, date, radio, select, checkbox, file, textarea, range, hidden inputs |
| Lab 4 | `lab4_frames_iframes.html` | Three frame layouts using modern iframes: floating frame, navigation frame, mixed frame |
| Lab 5 | `lab5_image_map.html` | Clickable image maps: `shape="circle"`, `shape="rect"`, `shape="poly"`, and all three on one mixed map |
| Lab 6 | `lab6_css_styles.html` + `lab6_style.css` | All three CSS methods: **inline** (`style=""`), **internal** (`<style>` block), **external** (`<link>` to `.css` file) |

---

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/YOUR_USERNAME/web-d-mid-term.git
   cd web-d-mid-term
   ```

2. Open any HTML file directly in your browser:
   - **Mac/Linux:** `open q20_nav_iframe.html`
   - **Windows:** Double-click the file in File Explorer

3. No build tools or server required — pure HTML/CSS.

---

## 🔑 Key Concepts Covered

| Concept | Tag / Property |
|---------|---------------|
| IFrame | `<iframe src="" width="" height="" name="">` |
| IFrame Target | `<a target="frame-name">` + `<iframe name="frame-name">` |
| List types | `<ul>`, `<ol>`, `<dl>`, nested lists |
| Table layout | `<table>`, `colspan`, `rowspan` |
| Form inputs | `text`, `email`, `password`, `date`, `number`, `file`, `range`, `radio`, `checkbox`, `select`, `textarea` |
| Image Map | `<map>`, `<area shape="circle/rect/poly">` |
| CSS Inline | `style=""` on element |
| CSS Internal | `<style>` inside `<head>` |
| CSS External | `<link rel="stylesheet" href="file.css">` |

---

## 👤 Author

**Aditya Pandey**  
Web Development – Mid Term Assignment  
March 2026
