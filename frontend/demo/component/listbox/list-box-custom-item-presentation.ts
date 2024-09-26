import 'Frontend/demo/init'; // hidden-source-line
import '@vaadin/avatar';
import '@vaadin/horizontal-layout';
import '@vaadin/item';
import '@vaadin/list-box';
import '@vaadin/vaadin-lumo-styles/typography';
import '@vaadin/vertical-layout';
import { html, LitElement } from 'lit';
import { customElement, state } from 'lit/decorators.js';
import { getPeople } from 'Frontend/demo/domain/DataService';
import type Person from 'Frontend/generated/com/vaadin/demo/domain/Person';
import { applyTheme } from 'Frontend/generated/theme';

@customElement('list-box-custom-item-presentation')
export class Example extends LitElement {
  protected override createRenderRoot() {
    const root = super.createRenderRoot();
    // Apply custom theme (only supported if your app uses one)
    applyTheme(root);
    return root;
  }

  @state()
  private items: Person[] = [];

  protected override async firstUpdated() {
    const { people } = await getPeople({ count: 5 });
    this.items = people;
  }

  protected override render() {
    return html`
      <!-- tag::snippet[] -->
      <vaadin-list-box multiple .selectedValues="${[0, 2]}">
        ${this.items.map(
          (person) => html`
            <vaadin-item style="line-height: var(--lumo-line-height-m);">
              <vaadin-horizontal-layout style="align-items: center;" theme="spacing">
                <vaadin-avatar
                  .img="${person.pictureUrl}"
                  .name="${`${person.firstName} ${person.lastName}`}"
                ></vaadin-avatar>
                <vaadin-vertical-layout>
                  <span> ${person.firstName} ${person.lastName} </span>
                  <span
                    style="color: var(--lumo-secondary-text-color); font-size: var(--lumo-font-size-s);"
                  >
                    ${person.profession}
                  </span>
                </vaadin-vertical-layout>
              </vaadin-horizontal-layout>
            </vaadin-item>
          `
        )}
      </vaadin-list-box>
      <!-- end::snippet[] -->
    `;
  }
}
