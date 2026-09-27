# SPDX-FileCopyrightText: 2024 awesome-computercraft contributors
#
# SPDX-License-Identifier: MIT

{
  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixpkgs-unstable";
    systems.url = "github:nix-systems/default";
  };

  outputs =
    {
      self,
      nixpkgs,
      systems,
    }@inputs:
    let
      forEachSystem = nixpkgs.lib.genAttrs (import systems);
    in
    {
      devShells = forEachSystem (
        system:
        let
          pkgs = nixpkgs.legacyPackages.${system};
        in
        {
          default = pkgs.mkShellNoCC {
            packages = [
			  pkgs.jdk8
			  pkgs.jdk25
            pkgs.gradle_9
            ];
            LD_LIBRARY_PATH = pkgs.lib.makeLibraryPath [
              pkgs.alsa-lib
              pkgs.libGL
              pkgs.libx11
              pkgs.libxcursor
              pkgs.libxext
              pkgs.libxi
              pkgs.libxrandr
              pkgs.libxxf86vm
            ];
            JAVA_HOME = pkgs.jdk25;
            JAVA8_HOME = "${pkgs.jdk8}/lib/openjdk";
            JAVA_TOOL_OPTIONS = "-Dorg.gradle.java.installations.fromEnv=JAVA8_HOME";
          };
        }
      );
    };
}
