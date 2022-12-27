import { RightSide, RightSidebar } from './SidebarWidget_style';
import { EditWidget } from './EditWidget';

export const SidebarWidget = () => {
  return (
    <RightSide>
      <RightSidebar>
        <header>The Overflow Blog</header>
        <ul>
          <li>ideal fit for developing blockchains</li>
          <li>Environments on-demand (Ep. 479)</li>
          <li>Add related resources or links</li>
          <li>Always respect the author’s intent</li>
          <li>Don’t use edits to reply to the author</li>
        </ul>
        <header>Featured on Meta</header>
        <ul>
          <li>Student Ambassador Program</li>
          <li>Google Analytics 4 (GA4) upgrade</li>
          <li>Question Lifecycle</li>
          <li>The [option] tag is being burninated</li>
          <li>WSO2 launches, and Google Go sunsets</li>
        </ul>
      </RightSidebar>
      <EditWidget />
    </RightSide>
  );
};
