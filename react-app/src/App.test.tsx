import { describe, it, expect } from "vitest";
import { render, screen } from "@testing-library/react";
import App from "./App";

describe("Home page", () => {
    it("Should render welcome text", () => {
        render(<App />);
        const heading = screen.getByRole("heading", {level: 1});
        expect(heading.textContent).toBe("Shopping cart app");
    })
})