import { RightSideWidget, RightSidebar } from './EditWidget_style';

export const EditWidget = () => {
  return (
    <RightSideWidget>
      <RightSidebar>
        <header>How to Edit</header>
        <ul>
          <li>Correct minor typos or mistakes</li>
          <li>Clarify meaning without changing it</li>
          <li>Add related resources or links</li>
          <li>Always respect the author’s intent</li>
          <li>Don’t use edits to reply to the author</li>
        </ul>
      </RightSidebar>
    </RightSideWidget>
  );
};
