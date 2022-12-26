import styled from "styled-components";

export const TagBox = styled.ul`
  margin: 4px 0;
  /* border: 1px solid red; */
  display: grid;
  gap: 12px;
  grid-template-columns: repeat(4, minmax(0, 1fr));
  /* Mobile*/
  @media screen and (max-width: 1260px) {
    grid-template-columns: repeat(3, minmax(0, 1fr));
  }
  /* Mobile*/
  @media screen and (max-width: 980px) {
    grid-template-columns: repeat(2, minmax(0, 1fr));
  }
  /* Mobile*/
  @media screen and (max-width: 640px) {
    grid-template-columns: repeat(1, minmax(0, 1fr));
  }
`;

export const TagInfo = styled.div`
  display: flex;
  width: 100%;
  height: 100%;

  > div {
    width: 100%;
    padding: 12px;
    border: 1px solid #babfc4;
    border-radius: 4px;
    box-sizing: inherit;
    &:focus-within {
      box-shadow: 0px 0px 3px 3px rgba(107, 186, 247, 0.5);
      border: none;
      outline: 0;
    }

    h6 {
      background-color: #e1ecf4;
      box-sizing: inherit;
      justify-content: center;
      align-items: center;
      color: var(--theme-link-color);
      font-size: 13px;
      border-radius: 2px;
      cursor: pointer;
      margin-bottom: 12px;
      display: inline-block;
      padding: 0.4em 0.5em;
      line-height: 1;
      white-space: nowrap;
      text-decoration: none;

      &:hover,
      &:active {
        color: var(--theme-link-color-hover);
      }
    }
    h5 {
      margin-bottom: 12px;
      font-size: 13px;
      color: var(--black-500);
      max-height: 67px;
      overflow: auto;
      display: -webkit-box;
      -webkit-line-clamp: 4;
      -webkit-box-orient: vertical;
      overflow: hidden;
      word-break: break-all;
    }
  }
`;

export const TagQuestion = styled.div`
  display: flex;
  justify-content: space-between;

  .question {
    color: #838c95;
    font-size: 12px;
  }
`;
// user 정보 question 페이지 참고
export const TagsSection = () => {
  return (
    <>
      <TagBox>
        <TagInfo>
          <div>
            <h6>JavaScript</h6>
            <h5>
              For questions about programming in ECMAScript (JavaScript/JS) and
              its different dialects/implementations (except for ActionScript).
              Keep in mind that JavaScript is NOT the same as Java! Include all
              labels that are relevant to your question; e.g., [node.js],
              [jQuery], [JSON], [ReactJS], [angular], [ember.js], [vue.js],
              [typescript], [svelte], etc.
            </h5>
            <TagQuestion>
              <div className="question">2442310 questions</div>
              <div className="question">608 asked today, 4105 this week</div>
            </TagQuestion>
          </div>
        </TagInfo>
        <TagInfo>
          <div>
            <h6>Python</h6>
            <h5>
              Python is a multi-paradigm, dynamically typed, multi-purpose
              programming language. It is designed to be quick to learn,
              understand, and use, and enforces a clean and uniform syntax.
              Please note that Python 2 is officially out of support as of
              2020-01-01. For version-specific Python questions, add the
              [python-2.7] or [python-3.x] tag. When using a Python variant
              (e.g. Jython, PyPy) or library (e.g. Pandas, NumPy), please
              include it in the tags.
            </h5>
            <TagQuestion>
              <div className="question">2052115 questions</div>
              <div className="question">992 asked today, 5934 this week</div>
            </TagQuestion>
          </div>
        </TagInfo>
        <TagInfo>
          <div>
            <h6>java</h6>
            <h5>
              Java is a high-level object-oriented programming language. Use
              this tag when you`re having problems using or understanding the
              language itself. This tag is frequently used alongside other tags
              for libraries and/or frameworks used by Java developers.
            </h5>
            <TagQuestion>
              <div className="question">1820432 questions</div>
              <div className="question">829 asked today, 3840 this week</div>
            </TagQuestion>
          </div>
        </TagInfo>
        <TagInfo>
          <div>
            <h6>c#</h6>
            <h5>
              c# (pronounced see sharp) is a high level, statically typed,
              multi-paradigm programming language developed by Microsoft. c#
              code usually targets Microsoft`s .NET family of tools and
              run-times, which include .NET, .NET Framework, .NET MAUI, and
              Xamarin among others. Use this tag for questions about code
              written in c# or about c#`s formal specification.
            </h5>
            <TagQuestion>
              <div className="question">1288343 questions</div>
              <div className="question">622 asked today, 3924 this week</div>
            </TagQuestion>
          </div>
        </TagInfo>
        <TagInfo>
          <div>
            <h6>php</h6>
            <h5>
              PHP is a widely used, open source, general-purpose,
              multi-paradigm, dynamically typed and interpreted scripting
              language designed initially for server-side web development. Use
              this tag for questions about programming in the PHP language.
            </h5>
            <TagQuestion>
              <div className="question">1288343 questions</div>
              <div className="question">622 asked today, 3924 this week</div>
            </TagQuestion>
          </div>
        </TagInfo>
        <TagInfo>
          <div>
            <h6>android</h6>
            <h5>
              Android is Google`s mobile operating system, used for programming
              or developing digital devices (Smartphones, Tablets, Automobiles,
              TVs, Wear, Glass, IoT). For topics related to Android, use
              Android-specific tags such as android-intent, android-activity,
              android-adapter, etc. For questions other than development or
              programming but related to the Android framework, use this link:
            </h5>
            <TagQuestion>
              <div className="question">1288343 questions</div>
              <div className="question">622 asked today, 3924 this week</div>
            </TagQuestion>
          </div>
        </TagInfo>
        <TagInfo>
          <div>
            <h6>html</h6>
            <h5>
              html (pronounced see sharp) is a high level, statically typed,
              multi-paradigm programming language developed by Microsoft. html
              code usually targets Microsoft`s .NET family of tools and
              run-times, which include .NET, .NET Framework, .NET MAUI, and
              Xamarin among others. Use this tag for questions about code
              written in html or about html`s formal specification.
            </h5>
            <TagQuestion>
              <div className="question">1288343 questions</div>
              <div className="question">622 asked today, 3924 this week</div>
            </TagQuestion>
          </div>
        </TagInfo>
        <TagInfo>
          <div>
            <h6>jquery</h6>
            <h5>
              jQuery is a JavaScript library. Consider also adding the
              JavaScript tag. jQuery is a popular cross-browser JavaScript
              library that facilitates Document Object Model (DOM) traversal,
              event handling, animations and AJAX interactions by minimizing the
              discrepancies across browsers. A question tagged jQuery should be
              related to jQuery, so jQuery should be used by the code in
              question, and at least jQuery usage-related elements must be in
              the question.
            </h5>
            <TagQuestion>
              <div className="question">1288343 questions</div>
              <div className="question">622 asked today, 3924 this week</div>
            </TagQuestion>
          </div>
        </TagInfo>
        <TagInfo>
          <div>
            <h6>c++</h6>
            <h5>
              C++ is a general-purpose programming language. It was originally
              designed as an extension to C and has a similar syntax, but it is
              now a completely different language. Use this tag for questions
              about code (to be) compiled with a C++ compiler. Use a
              version-specific tag for questions related to a specific standard
              revision [C++11], [C++14], [C++17], [C++20] or [C++23], etc.
            </h5>
            <TagQuestion>
              <div className="question">1288343 questions</div>
              <div className="question">622 asked today, 3924 this week</div>
            </TagQuestion>
          </div>
        </TagInfo>
        <TagInfo>
          <div>
            <h6>css</h6>
            <h5>
              CSS (Cascading Style Sheets) is a representation style sheet
              language used for describing the look and formatting of HTML
              (HyperText Markup Language), XML (Extensible Markup Language)
              documents and SVG elements including (but not limited to) colors,
              layout, fonts, and animations. It also describes how elements
              should be rendered on screen, on paper, in speech, or on other
              media.
            </h5>
            <TagQuestion>
              <div className="question">1288343 questions</div>
              <div className="question">622 asked today, 3924 this week</div>
            </TagQuestion>
          </div>
        </TagInfo>
        <TagInfo>
          <div>
            <h6>ios</h6>
            <h5>
              iOS is the mobile operating system running on the Apple iPhone,
              iPod touch, and iPad. Use this tag [ios] for questions related to
              programming on the iOS platform. Use the related tags
              [objective-c] and [swift] for issues specific to those programming
              languages.
            </h5>
            <TagQuestion>
              <div className="question">1288343 questions</div>
              <div className="question">622 asked today, 3924 this week</div>
            </TagQuestion>
          </div>
        </TagInfo>
        <TagInfo>
          <div>
            <h6>mysql</h6>
            <h5>
              MySQL is a free, open-source Relational Database Management System
              (RDBMS) that uses Structured Query Language (SQL). DO NOT USE this
              tag for other DBs such as SQL Server, SQLite etc. Those are
              different DBs that all use their own dialects of SQL to manage the
              data.
            </h5>
            <TagQuestion>
              <div className="question">1288343 questions</div>
              <div className="question">622 asked today, 3924 this week</div>
            </TagQuestion>
          </div>
        </TagInfo>
      </TagBox>
    </>
  );
};
