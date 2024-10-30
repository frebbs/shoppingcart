import { generateSchemaTypes, generateReactQueryComponents} from "@openapi-codegen/typescript";
import {defineConfig} from "@openapi-codegen/cli";

export default defineConfig({
    shoppingcart: {
        from: {
            relativePath: "../src/main/resources/openapi/shoppingcart.yaml",
            source: "file"
        },
        outputDir: "src/api",
        to: async (context) => {
            const filenamePrefix = "shoppingcart";
            const {schemasFiles} = await generateSchemaTypes(context, {
                filenamePrefix
            });
            await generateReactQueryComponents(context, {
                filenamePrefix,
                schemasFiles
            });
        },
    },
});
