import 'Frontend/demo/init'; // hidden-source-line
import '@vaadin/time-picker';
import { html, LitElement } from 'lit';
import { customElement } from 'lit/decorators.js';
import { applyTheme } from 'Frontend/generated/theme';

@customElement('time-picker-seconds-step')
export class Example extends LitElement {
  protected override createRenderRoot() {
    const root = super.createRenderRoot();
    // Apply custom theme (only supported if your app uses one)
    applyTheme(root);
    return root;
  }

  protected override render() {
    return html`
      <!-- tag::snippet[] -->
      <vaadin-time-picker label="Message received" value="15:45:08" step="1"></vaadin-time-picker>
      <!-- end::snippet[] -->
    `;
  }
}
