package com.vaadin.demo.component.map;

import com.vaadin.flow.component.map.configuration.style.Icon;

/**
 * DS publisher can not resolve default marker image, nor is there a way to host
 * static images with a deterministic URL. For now duplicate all required icons
 * with base64 encoded URL
 */
class Icons {
    public static Icon createDefaultIcon() {
        Icon.Options options = new Icon.Options();
        options.setSrc(
                " data:image/png;base64,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");
        options.setImgSize(new Icon.ImageSize(80, 104));
        options.setScale(0.5f);
        options.setAnchorOrigin(Icon.AnchorOrigin.BOTTOM_LEFT);
        options.setAnchor(new Icon.Anchor(0.5f, 0.12f));

        return new Icon(options);
    }

    public static Icon createGermanFlagIcon() {
        Icon.Options options = new Icon.Options();
        options.setSrc(
                "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAHr0lEQVRoQ+2Yy48cxR3Hq+f92od3s34sC1i2gi0sg1Fy85VHLojkGEVC/AERCCEhJRBp75EixCFIBlnKLZfcknMixIkcAIcEWB4hEmuzLGzWu7Pz6OkHn2911bo9mllPIo8Q0vTqt7/qqu7q7/f3qPrVBCZ3Xb58+U9nz579S6lU+tvVq1c/y4+Na6+vr1d2d3dXkyRZLRQKD6MfQi4NBoMH+/3+fK/XM91u91B0H4ahFcYPtdpRFBneszpN08NP1mo1s7i4aJrNptH7m5ubgR88bKhjeXk5vXDhgllZWTH1ev1TiHyE/Ae5yYR7AAy4agBs8fhp+u6L43iVD55EAoHwgKV1L/GgePYQGHMYicbUL9CegPo0NkxCRMBgdnZ2RhMAVFqtVi2BVqtlGesl9RWLRQN4S1yT563lAXoQ/uPSuvx70r4tcALuCUh70Tx6V+O69G3haDQalsDW1tZ4At41eqlcLhusb7Xu9fIwCPXpkvbj+WfzBPJh6AF6EnciQEQoKu5MwAPMaw/OA9O92nnxz+SJ5AF7y/s+T8B7764SGAYzTCBPxJMRwPx7w4CtJ5wosEJCpEuI7BM6HUKG+Lklulf4uRDCUqaJ9SXBnUJoGEgelAc+7Ilh4Pbe5wtgu8g+ctOZv4RuAHAOgMcAvgLgFXQBKSF97r9m/CbjX/LsdQgQP1aqzN0/Mgf4cNHF87AnRhEoudzQsynS4/199IEjUAPAcS1ZyDnkQeQMsgLAVQAuAHhxhAfajPcY/8YR2AT8W8hfmXtjHIE1VqEv9GEl5pCUuRdY248eoCPX9s/qmXt4/zT6PFpgJWcdgXxOHIYIBHoQ6KJDJ3Yf0DILgTIvLfK9BeeBPzP3k+MI/BECKR9+h4c+RD5BvkHasqgjIJBNJjyOPinAtNfQ9yI/RB7g/ftEzHngNtC5m6OSeACB2C2jypeCy4EYEhvM/cQ4An+AwE/4sMDJwjvIrgPfQSuE6o7AEnp5yAPWE96Dd5lAC/Ai8B7feGocgTcg8DAfnhNYRGAbTtfyYCGSOJIKJwHX6uD3Aa/HWV/9/6sHJiZwCQLzAusAicihALak/lziDi+pfhUbtYyO2shG7QOjQmhGwHphWh6IsyrUSoiMSOLv3gO+/GKTNSE50KFY61LMdSif+QN27k89jPOnohrTmVaZJD7mkvjLMcWckviu5EAxK/pAZEwHabvtWEmwiCxDYA6AcxCYh8ASBNBhQjvNPBDtM74HgRsQuAGB7bqJBnVzLWAVSo8iQMUyD2eylWTNJfBwCDHm6yBaphAjPYAfUBOF6BIEBPYUoh3yfrebaVdbhUATgA0IVABdhADgs/BxIRQyPoAAdUhhHwL/hcB7EHgTAn8fR+BRPPA5y+gnKpHluGGhArV9+p/92XaV1gKgV9H3U/Ofpn0GAqoZAG9OIHOIiiAVRgcuhHoQ6EOgn+VAKPDKA50HIggkCiI2/joETkKgVTf/eBsCT48j8BoE1iBwHQKfA24TQF9RQrRpY91iAbh4ptgA9AlAHqe9krWtrNF3Eg+0XAgpfFTFATpV7OtyuZDE2YHFWnzgktgRiLjXeAQBFaVaPFpNCCQQ+DcEfjmOwK8hcBEC90CgCTiFUYJOEULErkIKnQqgAVmo0BfQZiwgbApdpI8HeCcogNSBvXW6vbUTWICWAPHuVx9rfY6Y9niZEUx4uVjKEfi0YH767BgCr78MgXMQaLgQUtzL4mWAIfYAQxJZ0GiJ3chEinZgtY6NjgBriAWfY6CmeMXyQJSdha0HAB5J7HIKAech6wERaOABgwcI7589dxSBByCA9VPFNwRK8oJNYH8K070D7RLblg5Y3JLQwcbpYctrYbKHGv4lmFYWjmOBvvVrhCpSS8TlAFFkv9dwIXTtKAJXXjLpI3ig5QnIwhCwYeNKCEskR+C2M4OzvD/QWMDWIy6aBBxWAhWywvRJ3k6PE1mXcrqrcjr7ZSJmY6OexhAx3+YcUyuaxYU6O0PDvLthzFPPfjX6UP/Gb0z6o/MBR7eCiYn7DLRbSp0HrPWt5bMjZHYu9s/QlidcVSqw0SA1vTA1B93U7B0kZq/NMfIgNe1OZA6Qdie2BERmQNjoDJAAPuBXi1IxMdWKMfPk26njNbMwVzPXvy6an7+4PZrAKy9QjRJCJ5ay0MnCJhMB90BVzGV9WT/xY5fdOA5Mn132oM/i007NLmB39zga7gO6IxJJv9dPP4qj9GPA3ojT5Is0SjfTONlM0nB7kAaDOAhCE/WqrFrH8NQSKXCGUL7UaJQeajYqP56fq5gXfjvmd6FfPWPCei0on/pBwSwtBDDm8II3aqw6lUpgQykggZUfURLgcs6nA4EOsCKgASlps3x2+ul2P0w3SMb3+Q3oWjEtflAoBR+s/35bx9z/63r+mebF5fnqYy+/uvM7P8Ftv8y9+Auztt83j2HWx2slc7FWK5yrV4NSlRXIEsArHNkIr4BYFYFAebgFmS36NpMk+BdRcw3//bMSlDfWr1zXTjDV6zYCU/3SlCafEZiSYSeeduaBiU01pQdnHpiSYSeeduaBiU01pQdnHpiSYSeeduaBiU01pQdnHpiSYSeeduaBiU01pQdnHpiSYSee9nvvgW8BGMHjbYomh3cAAAAASUVORK5CYII=");
        options.setImgSize(new Icon.ImageSize(48, 48));
        options.setScale(0.6f);

        return new Icon(options);
    }

    public static Icon createUsFlagIcon() {
        Icon.Options options = new Icon.Options();
        options.setSrc(
                "data:image/png;base64,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");
        options.setImgSize(new Icon.ImageSize(48, 48));
        options.setScale(0.6f);

        return new Icon(options);
    }
}
