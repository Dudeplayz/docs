import 'Frontend/demo/init'; // hidden-source-line
import '@vaadin/button';
import '@vaadin/horizontal-layout';
import '@vaadin/icon';
import '@vaadin/notification';
import '@vaadin/vaadin-lumo-styles/vaadin-iconset';
import { html, LitElement } from 'lit';
import { customElement, state } from 'lit/decorators.js';
import type { NotificationOpenedChangedEvent } from '@vaadin/notification';
import type { NotificationLitRenderer } from '@vaadin/notification/lit.js';
import { notificationRenderer } from '@vaadin/notification/lit.js';
import { applyTheme } from 'Frontend/generated/theme';

@customElement('notification-error')
export class Example extends LitElement {
  @state()
  private notificationOpened = true;

  protected override createRenderRoot() {
    const root = super.createRenderRoot();
    // Apply custom theme (only supported if your app uses one)
    applyTheme(root);
    return root;
  }

  protected override render() {
    return html`
      <vaadin-button .disabled="${this.notificationOpened}" @click="${this.open}">
        Show notification
      </vaadin-button>

      <!-- tag::snippet[] -->
      <!-- The duration is set to 0-sec to prevent the notification from auto-close. -->
      <vaadin-notification
        theme="error"
        duration="0"
        position="middle"
        .opened="${this.notificationOpened}"
        @opened-changed="${(e: NotificationOpenedChangedEvent) => {
          this.notificationOpened = e.detail.value;
        }}"
        ${notificationRenderer(this.renderer, [])}
      ></vaadin-notification>
      <!-- end::snippet[] -->
    `;
  }

  // tag::renderer[]
  renderer: NotificationLitRenderer = () => html`
    <vaadin-horizontal-layout theme="spacing" style="align-items: center;">
      <div>Failed to generate report</div>
      <vaadin-button theme="tertiary-inline" @click="${this.close}" aria-label="Close">
        <vaadin-icon icon="lumo:cross"></vaadin-icon>
      </vaadin-button>
    </vaadin-horizontal-layout>
  `;
  // end::renderer[]

  private open() {
    this.notificationOpened = true;
  }

  private close() {
    this.notificationOpened = false;
  }
}
